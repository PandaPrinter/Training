public class Solution {
    public boolean increasingTriplet(int[] nums) {
        
        /*
         // method 1:
         int[] dp = new int[3];
         int len = 0;
         for (int num : nums) {
         int i = Arrays.binarySearch(dp, 0, len, num);
         if (i < 0) i = - i - 1;
         dp[i] = num;
         if (i == len) len++;
         if (len == 3) return true;
         }
         return false;
         */
        
        // method 2:
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= small) small = num;
            else if (num <= big) big = num;
            else return true;
        }
        return false;
    }
    
}