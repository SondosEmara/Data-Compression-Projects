/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lz77;

import java.util.ArrayList;
import java.util.List;

class Lz77Decompression {

    private List<Integer> tags;
    private String afterDecompression;

    Lz77Decompression() {
        this.tags = new ArrayList<>();
        this.afterDecompression = "";
    }

    public void setTags(List<Integer> tags) {
        this.tags = tags;
    }

    public String dataAfterDecompression() {
        return afterDecompression;
    }

    void makeDecompression() {

        /*
        currentPosition is the currentPosition of the afterDecompression String
        position belong to the tag Position*/
        int position, currentPosition = 0;

        for (int i = 0; i < tags.size(); i += 3) {
            position = tags.get(i);
            if (position == 0) {
                afterDecompression += (char) ((int) tags.get(i + 2));

            } else {

                for (int counter = 0; counter < tags.get(i + 1); counter++) {
                    int symbolIndex = currentPosition - position;
                    afterDecompression += afterDecompression.charAt(symbolIndex);
                    currentPosition++;

                }

                if (tags.get(i + 2) != null) {

                    afterDecompression += (char) ((int) tags.get(i + 2));
                }

            }
            currentPosition++;

        }

    }

}
