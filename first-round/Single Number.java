public class Solution {
    public int singleNumber(int[] nums) {
        
        /*
         // method 1
         int res = 0;
         Set<Integer> set = new HashSet<Integer>();
         for (int n : nums) {
         if (!set.contains(n)) {
         set.add(n);
         }
         else {
         set.remove(n);
         }
         }
         for (int i : set) {
         res = i;
         }
         return res;
         */
        
        int res = 0;
        for (int i : nums) {
            res = res ^ i;
        }
        return res;
    }
    
}