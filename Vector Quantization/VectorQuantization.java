package vectorquantization;

import java.util.Scanner;

public class VectorQuantization {

    public static void main(String[] args){

        /*
        TestCases
        compressObj.makeCompression(2,2,6);
        compressObj.makeCompression(2,4,4);
        compressObj.makeCompression(4,2,4);
        compressObj.makeCompression(4,4,4);
        compressObj.makeCompression(4,4,5);
        compressObj.makeCompression(4,4,6);
        compressObj.makeCompression(3,3,6);
        compressObj.makeCompression(2,2,4);
        */
        Compression compressObj = new Compression("Image.jpg");
        System.out.println("Enter the Width Vector: ");
        Scanner in = new Scanner(System.in);
        int width = in.nextInt();

        System.out.println("Enter the Hight Vector: ");
        int height=in.nextInt();

        System.out.println("Enter the number of codeBlocks: ");
        int numCodeBlocks=in.nextInt();

       if(width != height ){
           int number = Math.min(width,height);
           compressObj.makeCompression(number, number, numCodeBlocks);
        }
        else {
            compressObj.makeCompression(width, height, numCodeBlocks);
       }


        compressObj.printCodeMatrix();

        System.out.println("-------------------------***********************************-------------------------");

        //Decompress

        Decompression decompress = new Decompression(compressObj.getCodeMatrix(), compressObj.averageList);
        decompress.makeDecompression();

        decompress.printDecompressMatrix();
    }
}