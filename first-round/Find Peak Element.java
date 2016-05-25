public class Solution {
    public int findPeakElement(int[] nums) {
        
        int len = nums.length;
        int low = 0, high = len - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        return low;
    }
}