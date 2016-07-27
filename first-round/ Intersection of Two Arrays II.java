public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i : nums1) {
            if (map1.containsKey(i)) {
                map1.put(i, map1.get(i) + 1);
            }
            else map1.put(i, 1);
        }
        for (int i : nums2) {
            if (map1.containsKey(i) && map1.get(i) > 0) {
                res.add(i);
                map1.put(i, map1.get(i) - 1);
            }
        }
        int index = 0;
        int[] resArr = new int[res.size()];
        for (int i : res) {
            resArr[index++] = i;
        }
        return resArr;
    }
    
}