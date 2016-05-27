public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        
        /*
         // method 1:
         int minSize = Integer.MAX_VALUE;
         int n = nums.length;
         int low = 0;
         int high = 0;
         int sum = 0;
         
         while (high < n) {
         sum += nums[high++];
         
         while (sum >= s) {
         minSize = Math.min(minSize, high - low);
         sum -= nums[low++];
         }
         }
         return minSize == Integer.MAX_VALUE ? 0 : minSize;
         */
        
    }
}