public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String str = String.valueOf(x);
        int m = 0, n = str.length() - 1;
        while (m <= n) {
            if (str.charAt(m) != str.charAt(n)) {
                return false;
            }
            m++;
            n--;
        }
        return true;
    }
    
}