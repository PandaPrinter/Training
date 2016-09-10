// bucket method

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long val = (long) nums[i] - Integer.MIN_VALUE;
            long id = val / ((long) t + 1);
            if (map.containsKey(id)) return true;
            if (map.containsKey(id - 1) && ((long) val - map.get(id - 1) <= t)) return true;
            if (map.containsKey(id + 1) && (map.get(id + 1) - val <= t)) return true;
            map.put(id, val);
            if (i >= k) map.remove(((long) nums[i-k] - Integer.MIN_VALUE) / ((long) t + 1));
        }
        return false;
    }
}


// BST: Nlgk

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long down = set.ceiling((long) nums[i] - t);
            Long up = set.floor((long) nums[i] + t);
            if ((down != null && nums[i] >= down) || (up != null && nums[i] <= up)) return true;
            set.add((long) nums[i]);
            if (i >= k) set.remove((long) nums[i-k]);
        }
        return false;
    }
}
