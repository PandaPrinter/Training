public class Solution {
    public void sortColors(int[] nums) {
        int zero = 0, two = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int temp = nums[zero];
                nums[zero] = nums[i];
                nums[i] = temp;
                zero++;
            }
            else if (nums[i] == 2) {
                if (i <= two) {
                    int temp = nums[i];
                    nums[i] = nums[two];
                    nums[two] = temp;
                    two--;
                    i--;
                }
            }
        }
    }
    
}