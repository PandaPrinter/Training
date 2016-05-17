public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int p = 0;
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i - 1] < nums[i]) {
                p = i - 1;
                break;
            }
        }
        int q = 0;
        for (int i = nums.length - 1; i > p; i--) {
            if (nums[i] > nums[p]) {
                q = i;
                break;
            }
        }
        if (p == 0 && q == 0) {
            reverseArr(nums, 0, nums.length - 1);
        }
        else {
            int temp = nums[p];
            nums[p] = nums[q];
            nums[q] = temp;
            if (p < nums.length - 1) {
                reverseArr(nums, p + 1, nums.length - 1);
            }
        }
    }
    private void reverseArr(int[] nums,int left, int right) {
        for (int i = left; i <= (right + left) / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[left + right - i];
            nums[left + right - i] = temp;
        }
    }
    
}