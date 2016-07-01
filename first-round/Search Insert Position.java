public class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                break;
            }
            else if (nums[mid] > target) {
                if (mid == 0 || nums[mid - 1] < target) {
                    break;
                }
                else end = mid - 1;
            }
            else {
                if (mid == nums.length - 1 || nums[mid + 1] > target) {
                    mid = mid + 1;
                    break;
                }
                else start = mid + 1;
            }
        }
        return mid;
    }
    
}