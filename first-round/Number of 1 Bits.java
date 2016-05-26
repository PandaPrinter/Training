public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        
        /*
         // method 1:
         int count = 0;
         String binary = Integer.toBinaryString(n);
         for (char c : binary.toCharArray()) {
         if (c == '1') count++;
         }
         return count;
         */
        
        int ones = 0;
        while (n != 0) {
            ones += (n & 1);
            n = n >>> 1;
        }
        return ones;
    }
    
}