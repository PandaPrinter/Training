public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        // method 1:
        
        int[] arr = new int[primes.length];
        int[] res = new int[n];
        
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                res[i] = Math.min(res[i], primes[j] * res[arr[j]]);
            }
            
            for (int j = 0; j < primes.length; j++) {
                if (res[i] == primes[j] * res[arr[j]]) arr[j]++;
            }
        }
        
        return res[n-1];
    }
    
}