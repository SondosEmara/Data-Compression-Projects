

package standardhuffman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
Test casess
1-EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEETTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIINNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCUUUUUUUUUUUUUUUUUUUUUUUUUUU
2-aaaaaaaaaaeeeeeeeeeeeeeeiiiiiiiiiiiiooouuuussssssssssssst
3-  h hhbhhd hjdhbhf 125865qqqqqqqqqqqqqqqqqqqqqqqqqyyyyyyyyyyyyyyqqqqqqaaaaaaaaaaaaaaaaaavvvvvvvvvvjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjoooooooooooopppppppppppppppppppppppppppp
4- ddddddddddddddddddddddddddddddddddddddddddddffffffffffffffffffffffffffffffgggggggghhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh
5-The quick brown fox jumps over the lazy dog
*/
public class StandardHuffman {

    public static String readFromFile(String fileName) throws IOException {
        File file = new File(fileName);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String currentLine = reader.readLine();
        reader.close();
        return currentLine;
    }

    public static void main(String[] args) throws IOException {

        //the Compression part.
        String textToBeCompressed = StandardHuffman.readFromFile("mainFile.txt");

        HuffmanCompression comEx = new HuffmanCompression(textToBeCompressed);

        System.out.println("----------------The Data From File before make Compress--------------------------");
        System.out.println(textToBeCompressed);
        
        comEx.compressionLogic();
        comEx.printCharCount();

        System.out.println("--------------------------The Chars Code Numbers  after make commpression-------------------");
        comEx.printcodeNumber();
        comEx.getComResult();

        System.out.println('\n' + "------------------------The Commpression Ratio -----------------------------------");
        System.out.println(comEx.compressionRatio());

        // The decompression part.
        HuffmanDecompression decompEx = new HuffmanDecompression();

        String binaryResult = StandardHuffman.readFromFile("afterCompression.txt");

        String codes = StandardHuffman.readFromFile("codeNumbers.txt");

        HuffmanDecompression.convertToMap(codes);

        HuffmanDecompression.decompress(binaryResult);

        System.out.println("-----------------------------After make Decompression----------------------------");

        
        try {
           HuffmanDecompression.displayDecodedText();
        } catch (IOException e) {
        }
        //System.out.println("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEETTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIINNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCUUUUUUUUUUUUUUUUUUUUUUUUUUU".equals(textToBeCompressed));
}
}















































































