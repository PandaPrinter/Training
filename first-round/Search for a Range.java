public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = binarySearch1(nums, target, 0, nums.length - 1);
        res[1] = binarySearch2(nums, target, 0, nums.length - 1);
        return res;
    }
    private int binarySearch1(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                if (start == end || start == mid) return mid;
                else {
                    end = mid;
                }
            }
            else if (nums[mid] > target) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return -1;
    }
    private int binarySearch2(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                if (start == end) return mid;
                else if (start == mid) {
                    return nums[end] == target ? end : mid;
                }
                else {
                    start = mid;
                }
            }
            else if (nums[mid] > target) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return -1;
    }
    
}