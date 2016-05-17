public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[] {nums.length, -1};
        searchRange(0, nums.length - 1, nums, target, result);
        if (result[0] > result[1]) {
            result[0] = -1;
        }
        return result;
    }
    private void searchRange(int start, int end, int[] nums, int target, int[] result) {
        if (start > end) return;
        int middle = (start + end) / 2;
        if (nums[middle] == target) {
            if (middle < result[0]) {
                result[0] = middle;
                this.searchRange(start, middle - 1, nums, target, result);
            }
            if (middle > result[1]) {
                result[1] = middle;
                this.searchRange(middle + 1, end, nums, target, result);
            }
        }
        else if (nums[middle] > target) {
            this.searchRange(start, middle - 1, nums, target, result);
        }
        else {
            this.searchRange(middle + 1, end, nums, target, result);
        }
    }
    
}