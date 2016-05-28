public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) return false;
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.isEmpty()) {
                Integer floor = set.floor(nums[i] + t);
                Integer ceil = set.ceiling(nums[i] - t);
                if ((ceil != null && nums[i] >= ceil) || (floor != null && nums[i] <= floor)) return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
    
}