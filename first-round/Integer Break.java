public class Solution {
    public int integerBreak(int n) {
        int factor3 = 0;
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;
        while (n > 4) {
            n -= 3;
            factor3++;
        }
        return (int) Math.pow(3,factor3)*n;
    }
    
}