public class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i <= n / 2; i++) {
            for (int j = 1; Math.max(i, j) <= n - i - j; j++) {
                if (helper(i, j, num)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean helper(int i, int j, String num) {
        if(num.charAt(0) == '0' && i > 1) return false;
        if (num.charAt(i) == '0' && j > 1) return false;
        
        Long s1 = Long.parseLong(num.substring(0, i));
        Long s2 = Long.parseLong(num.substring(i, j+i));
        
        String sum;
        
        for (int start = i + j; start != num.length(); start += sum.length()) {
            s2 = s1 + s2;
            s1 = s2 - s1;
            sum = s2.toString();
            if (!num.substring(start).startsWith(sum)) return false;
        }
        
        return true;
    }
}