public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        //method 1:
        /*
         Set<Integer> set = new HashSet<>();
         List<Integer> list = new ArrayList<>();
         
         for (int i : nums2) {
         set.add(i);
         }
         for (int j : nums1) {
         if (set.size() == 0) {
         break;
         }
         if (set.contains(j)) {
         list.add(j);
         set.remove(j);
         }
         }
         int[] res = new int[list.size()];
         int index = 0;
         for (int i : list) {
         res[index++] = i;
         }
         return res;
         */
        
        //method 2:
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            }
            else if (nums1[i] > nums2[j]) {
                j++;
            }
            else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] res = new int[set.size()];
        int index = 0;
        for (int e : set) {
            res[index++] = e;
        }
        return res;
    }
    
}