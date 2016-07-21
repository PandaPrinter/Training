public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) return true;
        s = s.trim();
        int lo = 0, hi = s.length() - 1;
        while (lo < hi) {
            if (!Character.isLetterOrDigit(s.charAt(lo))) {
                lo++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(hi))) {
                hi--;
                continue;
            }
            else {
                if (Character.toLowerCase(s.charAt(lo)) != Character.toLowerCase(s.charAt(hi))) return false;
                else {
                    lo++;
                    hi--;
                }
            }
        }
        return true;
    }
    
}