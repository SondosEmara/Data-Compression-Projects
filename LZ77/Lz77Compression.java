package lz77;

import java.util.ArrayList;
import java.util.List;

class Lz77Compression {

    private List<Integer> tags;
    private int tagPosition;
    private String dataInput;

    public Lz77Compression() {
        this.tags = new ArrayList<>();
        dataInput = "";
        tagPosition = 0;
    }

    private boolean searchMatch(String searchBuffer, String target) {

        int bufferLen = searchBuffer.length();
        int targetLen = target.length();
        String sequence;
        for (int i = bufferLen - 1; i >= 0 && (i + 1) >= targetLen; i--) {
            sequence = "";
            for (int j = i - targetLen + 1; j <= i; j++) {
                sequence += searchBuffer.charAt(j);

            }
            if (sequence.equals(target)) {
                tagPosition = bufferLen - (i - targetLen + 1);
                return true;
            }
        }
        return false;
    }

    void makeCompression() {

        String sequence = "";
        String searchBuffer = "";
        boolean check = false;

        for (int currentPosition = 0; currentPosition < dataInput.length(); currentPosition++) {
            sequence += dataInput.charAt(currentPosition);

            if (searchMatch(searchBuffer, sequence)) {
                check = true;

            } else {
                if(check==false) tagPosition=0;
                tags.add(tagPosition);
                tags.add(sequence.length() - 1);
                tags.add((int) (dataInput.charAt(currentPosition)));

                searchBuffer += sequence;
                sequence = "";
                check = false;
            }

        }
        if (check) {

            tags.add(tagPosition);
            tags.add(sequence.length());
            tags.add(null);
        }

    }

    void printTags() {

        System.out.println("------------------------The Tags After make Compression is----------------------");

        for (int i = 0; i < tags.size(); i += 3) {

            System.out.print("<" + tags.get(i) + "," + tags.get(i + 1) + ",");

            if (tags.get(i + 2) != null) {
                System.out.println((char) ((int) tags.get(i + 2)) + ">");
            } else {
                System.out.println("null" + ">");
            }
        }

    }

    List<Integer> getTags() {
        return tags;
    }

    void setData(String dataInput) {
        this.dataInput = dataInput;
    }

}
