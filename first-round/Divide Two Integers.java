public class Solution {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            sign = -1;
        }
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        long res = helper(ldividend, ldivisor);
        if (res > Integer.MAX_VALUE && sign == 1) return Integer.MAX_VALUE;
        if (res > Integer.MAX_VALUE && sign == -1) return Integer.MIN_VALUE;
        return sign * (int) res;
    }
    public long helper(long ldividend, long ldivisor) {
        if (ldividend < ldivisor) return 0;
        long sum = ldivisor;
        long multiple = 1;
        while (sum + sum < ldividend) {
            sum += sum;
            multiple += multiple;
        }
        return multiple + helper(ldividend - sum, ldivisor);
    }
    
}