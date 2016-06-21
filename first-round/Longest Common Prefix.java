public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs == null) return "";
        String res = strs[0];
        if (strs.length == 1) return res;
        for (int i = 1; i < strs.length; i++) {
            res = findCommonPrefix(res, strs[i]);
        }
        return res;
    }
    public String findCommonPrefix(String s1, String s2) {
        String prefix = s1.length() < s2.length() ? s1 : s2;
        if (prefix.equals(s1)) {
            while (!s2.startsWith(prefix) && prefix.length() != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        else {
            while (!s1.startsWith(prefix) && prefix.length() != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
    
}