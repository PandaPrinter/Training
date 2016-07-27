public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        List<Integer> res = new LinkedList<>();
        for (int i : nums1) set.add(i);
        for (int j : nums2) {
            if (set.contains(j)) {
                res.add(j);
                set.remove(j);
            }
        }
        int index = 0;
        int[] finalRes = new int[res.size()];
        for (Integer i : res) {
            finalRes[index++] = i;
        }
        return finalRes;
    }
    
}