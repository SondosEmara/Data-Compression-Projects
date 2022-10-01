package arithmeticcoding;

import java.io.FileNotFoundException;

public class Arithmetic_Coding {

    public static void main(String[] args) throws FileNotFoundException {

        String word = "ABCAAAAAAC";

        System.out.println(word);

        compression compressObj = new compression();

        compressObj.compress(word);

        Decompression obj = new Decompression();
        obj.setcompressResult("compressResult.txt");
        obj.setprobabilitiesFile("probabilities.txt");
        obj.decompress();

        System.out.println("-----------------------------After make a Decompress ---------------------------");
        System.out.println(obj.getResult());

    }
}
