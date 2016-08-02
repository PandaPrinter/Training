public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        
        
        // dp
        if (primes.length == 0) return 1;
        int[] res = new int[n];
        int[] records = new int[primes.length];
        
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                if (primes[j] * res[records[j]] < min) {
                    min = primes[j] * res[records[j]];
                }
            }
            for (int j = 0; j < primes.length; j++) {
                if (min == primes[j] * res[records[j]]) records[j]++;
            }
            res[i] = min;
        }
        
        return res[n - 1];
        
    }
}