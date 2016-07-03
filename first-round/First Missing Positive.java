public class Solution {
    public int firstMissingPositive(int[] nums) {
        int res = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            while (val > 0 && val <= nums.length && nums[val - 1] != val) {
                swap(val - 1, i, nums);
                val = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != (i + 1)) {
                res = i + 1;
                break;
            }
        }
        return res;
    }
    private void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    
}