public class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        int index = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            int val = nums[i] - (index - i);
            if (val >= 0) {
                index = i;
            }
        }
        return index == 0;
    }
    
}