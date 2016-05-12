public class Solution {
    public boolean isPowerOfTwo(int n) {
        /*
         return n > 0 && (n & (n - 1)) == 0;
         */
        
        if (n < 0) {
            return false;
        }
        
        int numOfOne = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                numOfOne++;
            }
            n = n >> 1;
        }
        
        if (numOfOne == 1) {
            return true;
        }
        else {
            return false;
        }
    }
    
}