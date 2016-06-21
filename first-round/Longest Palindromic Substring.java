public class Solution {
    private int maxlen = 0;
    private String res = null;
    public String longestPalindrome(String s) {
        int len = s.length();
        int low = 0, high = len - 1;
        for (int i = 0; i < s.length(); i++) {
            extendPalindromic(s, i, i);
            extendPalindromic(s, i, i + 1);
        }
        return res;
    }
    public void extendPalindromic(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        if (end - start + 1 > maxlen) {
            maxlen = end - start + 1;
            res = s.substring(start + 1, end);
        }
    }
    
}