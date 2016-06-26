public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        int res = -1;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                res = i;
                break;
            }
        }
        return res;
    }
    
}