package lz77;

public class Lz77 {

   
    public static void main(String[] args) {
        
        /*
        Test casses 
        Testcase1: "ABAABABAABBBBBBBBBBBBA"
        Testcase2: "__  RTYRRRNN"
        Testcase3:"AB00S5800" 
        TestCase4:"AA"
        TestCase5:"0125975..."
        TestCase6:"ABA0HH"
        TestCase7:"-6 -+hh+++++--58"
        TestCase8:"ABAABABAABBBBBBBBBBBBAjinAB"
        TestCase9:"ABAABABAABBBBBBBBBBBBAjinAB DDGHJSUWOPB HHJSG656824FDGAGJAGISJKB"
        */
        
        
        
        String dataInput ="AABABABBCBCBBBBBBBBBBBBBBBBBCBCBCBBBCABBA"; 
        System.out.println("--------------------------The OrignailData is----------------------------------");
        System.out.println(dataInput);
        Lz77Compression compData = new Lz77Compression();
         
        compData.setData(dataInput);
        compData.makeCompression();
        compData.printTags();
                
        Lz77Decompression decompData=new Lz77Decompression();
        
        decompData.setTags(compData.getTags());
        decompData.makeDecompression();
        
        System.out.println("-------------------------After Make Decompression--------------------------------");
        System.out.println(decompData.dataAfterDecompression());//string (After Decompression)
        
        //System.out.println("AABABABBCBCBBBBBBBBBBBBBBBBBCBCBCBBBCABBA".equals(dataInput));
        
                
       
    }
}
