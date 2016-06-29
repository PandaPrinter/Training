public class Solution {
    public void nextPermutation(int[] nums) {
        int num = 0;
        int j = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                num = nums[i - 1];
                j = i - 1;
                break;
            }
            if (i == 1) {
                Arrays.sort(nums);
                return;
            }
        }
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > num) {
                int temp = num;
                nums[j] = nums[i];
                nums[i] = temp;
                break;
            }
        }
        reverseSort(j + 1, nums.length - 1, nums);
    }
    
    private void reverseSort(int start, int end, int[] nums) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    
}