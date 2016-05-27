public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        /*
         // method 1:
         Set<Integer> set = new HashSet<>();
         for (int i = 0; i <= Math.min(nums.length - 1, k); i++) {
         if(set.contains(nums[i])) return true;
         set.add(nums[i]);
         }
         if (k < nums.length) {
         for (int i = k + 1; i < nums.length; i++) {
         set.remove(nums[i - k - 1]);
         if (set.contains(nums[i])) return true;
         set.add(nums[i]);
         }
         }
         return false;
         */
        
        // method 2:
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) set.remove(nums[i - k - 1]);
            if (!set.add(nums[i])) return true;
        }
        return false;
    }
    
}