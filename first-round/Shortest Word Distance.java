public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int index1 = -1, index2 = -1, min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                index1 = i;
                if (index2 != -1) min = Math.min(min, index1 - index2);
            }
            if (words[i].equals(word2)) {
                index2 = i;
                if (index1 != -1) min = Math.min(min, index2 - index1);     
            }
        }
        return min;
    }
}
