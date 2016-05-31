public class Solution {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0) return 0;
        int len = words.length;
        int[] values = new int[len];
        
        for (int i = 0; i < len; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                values[i] |= 1 << (word.charAt(j) - 'a');
            }
        }
        
        int maxProduct = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i+1; j < len; j++) {
                if ((values[i] & values[j]) == 0) {
                    maxProduct = Math.max(maxProduct, words[i].length() * words[j].length());
                }
            }
        }
        
        return maxProduct;
    }
    
}