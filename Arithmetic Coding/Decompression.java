package arithmeticcoding;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Decompression {

    private double compressionCode;
    private int wordLen;
    private String compressResult;
    private ArrayList<Character> differntwordCharachter = new ArrayList<>();
    private ArrayList<Double> characterProbabilities = new ArrayList<>();
    private String probabilities;
    ArrayList<wordSymbol> Symbols = new ArrayList<>();
    String result = "";

    void decompress() throws FileNotFoundException {

        double lower = 0;
        double upper = 0;

        readCompressResultFile();
        readprobabilitiesFile();
        createSymbols();
        double compressionCodeSave = compressionCode;
        for (int i = 0; i < wordLen; i++) {
            for (int j = 0; j < Symbols.size(); j++) {

                if (compressionCode < Symbols.get(j).getHighRange() && compressionCode > Symbols.get(j).getLowRange()) {

                    if (i == 0) {
                        lower = 0;
                        upper = Symbols.get(j).highRange;
                    } else {
                        double prevLower = lower;
                        lower = prevLower + (upper - lower) * Symbols.get(j).lowRange;
                        upper = prevLower + (upper - prevLower) * Symbols.get(j).highRange;
                    }
                    compressionCode = (compressionCodeSave - lower) / (upper - lower);

                    result += Symbols.get(j).character;
                    break;
                }
            }

        }

    }

    void setprobabilitiesFile(String fileName) {
        probabilities = fileName;

    }

    void setcompressResult(String fileName) {
        compressResult = fileName;
    }

    void readCompressResultFile() throws FileNotFoundException {
        // pass the path to the file as a parameter
        FileInputStream file = new FileInputStream(compressResult);
        Scanner sc = new Scanner(file);
        int count = 0;
        while (sc.hasNextLine()) {
            if (count == 0) {
                wordLen = Integer.parseInt(sc.nextLine());
                count++;
            } else {
                compressionCode = Double.parseDouble(sc.nextLine());
            }
        }
    }

    void readprobabilitiesFile() throws FileNotFoundException {
        // pass the path to the file as a parameter
        File file = new File(probabilities);
        Scanner sc = new Scanner(file);
        String line;
        String[] data = new String[2];
        while (sc.hasNextLine()) {
            data = new String[2];
            line = sc.nextLine();
            data = line.split(" ");
            differntwordCharachter.add(data[0].charAt(0));
            characterProbabilities.add(Double.parseDouble(data[1]));
        }
    }

    private void createSymbols() {
        for (int i = 0; i < differntwordCharachter.size(); i++) {
            wordSymbol newSymbol = new wordSymbol();
            newSymbol.setchar(differntwordCharachter.get(i));
            Symbols.add(newSymbol);
            if (i == 0) {
                Symbols.get(i).setLowRange(0);
                Symbols.get(i).setHighRange(characterProbabilities.get(0));

            } else {
                double lowRange = Symbols.get(i - 1).getHighRange();
                Symbols.get(i).setLowRange(lowRange);
                double highRange = lowRange + characterProbabilities.get(i);
                Symbols.get(i).setHighRange(highRange);
            }
            Symbols.set(i, newSymbol);
        }
    }

    String getResult() {
        return result;
    }

}

class wordSymbol {

    char character;
    double lowRange;
    double highRange;

    public char getchar() {
        return character;
    }

    public void setchar(char character) {
        this.character = character;
    }

    public void setLowRange(double lowRange) {
        this.lowRange = lowRange;
    }

    public void setHighRange(double highRange) {
        this.highRange = highRange;
    }

    public double getLowRange() {
        return lowRange;
    }

    public double getHighRange() {
        return highRange;
    }

}
