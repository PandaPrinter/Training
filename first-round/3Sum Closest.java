public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int diff = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int low = i + 1, high = nums.length - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum == target) {
                    return target;
                }
                else if (sum < target) {
                    low++;
                }
                else {
                    high--;
                }
                diff = Math.abs(sum - target) < Math.abs(diff - target) ? sum : diff;
            }
        }
        return diff;
    }
    
}