package arithmeticcoding;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class compression {

    String word ;
    ArrayList<Character> list = new ArrayList<>();
    ArrayList<Symbol> Symbols = new ArrayList<>();
    double result = 0.0;

    public double compress(String word) {

        this.word = word;

        create_symbol(word);

        calculate_lowRange_highRange(word);

        double compressed = 0.0;

        for (int i = 0; i < word.length(); i++) {
            if (i == 0) {
                Symbols.get(i).setLower(0);
                Symbols.get(i).setUpper(P(word.charAt(i), word));
                Symbols.get(i).setRage(Symbols.get(i).getUpper() - Symbols.get(i).getLower());
            }
            else if (i == Symbols.size() - 1) {
                Symbols.get(i).setLower(Symbols.get(i - 1).getLower() + Symbols.get(i - 1).getRage() * Symbols.get(i).getLowRange());
                Symbols.get(i).setUpper(Symbols.get(i - 1).getLower() + Symbols.get(i - 1).getRage() * Symbols.get(i).getHighRange());
                Symbols.get(i).setRage(Symbols.get(i).getUpper() - Symbols.get(i).getLower());

                double low = Symbols.get(i).getLower();
                double high = Symbols.get(i).getUpper();
                double average = (low + high) / 2;

                compressed = average;
                System.out.println("compressed : " + compressed);
            }
            else {
                Symbols.get(i).setLower(Symbols.get(i - 1).getLower() + Symbols.get(i - 1).getRage() * Symbols.get(i).getLowRange());
                Symbols.get(i).setUpper(Symbols.get(i - 1).getLower() + Symbols.get(i - 1).getRage() * Symbols.get(i).getHighRange());
                Symbols.get(i).setRage(Symbols.get(i).getUpper() - Symbols.get(i).getLower());
            }
        }
        result = compressed;

        writeToFile();

        for(Symbol s : Symbols)
            s.print();

        return result;
    }

    public void create_symbol(String word) {
        for (int i = 0; i < word.length(); i++) {
            Symbol s = new Symbol();
            s.setchar(word.charAt(i));
            Symbols.add(s);
        }
    }

    public void calculate_lowRange_highRange(String word) {
        for (int i = 0; i < Symbols.size(); i++) {
            if (check(Symbols.get(i).character) == false) {
                if (i == 0) {
                    Symbols.get(i).setLowRange(0);
                    Symbols.get(i).setHighRange(P(Symbols.get(i).character, word));
                    list.add(Symbols.get(i).character);
                } else {
                    double lowRange = Symbols.get(i - 1).getHighRange();
                    Symbols.get(i).setLowRange(lowRange);
                    double highRange = lowRange + P(Symbols.get(i).character, word);
                    Symbols.get(i).setHighRange(highRange);

                    list.add(Symbols.get(i).character);
                }
            } else {
                // to check about repeating symbols
                for (int j = 0; j < i; j++) {
                    if (Symbols.get(i).character == Symbols.get(j).character) {
                        Symbols.get(i).setLowRange(Symbols.get(j).lowRange);
                        Symbols.get(i).setHighRange(Symbols.get(j).highRange);
                        break;
                    }
                }
            }
        }
    }

    public boolean check(char c) {
        boolean result = false;
        for (int j = 0; j < list.size(); j++) {
            if (list.get(j) == c) {
                result = true;
                break;
            }
        }
        return result;
    }

    public double P(char character, String word) {
        double count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == character)
                count++;
        }
        return count / word.length();
    }

    public void writeToFile() {
        try {
            FileWriter writer = new FileWriter("compressResult.txt");
            int len = word.length();
            writer.write(String.valueOf(len));
            writer.write('\n');
            writer.write(String.valueOf(result));
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            FileWriter writer = new FileWriter("probabilities.txt");
            for (int i = 0; i < list.size(); i++) {
                writer.write(list.get(i) + " ");
                writer.write(String.valueOf(P(list.get(i), word)));
                writer.write('\n');
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}