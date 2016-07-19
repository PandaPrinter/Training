public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        helper(res, nums, 0, list);
        return res;
    }
    private void helper(List<List<Integer>> res, int[] nums, int len, List<Integer> list) {
        if (len <= nums.length) {
            res.add(list);
        }
        for (int i = len; i < nums.length; i++) {
            list.add(nums[i]);
            helper(res, nums, i + 1, new ArrayList<>(list));
            list.remove(list.size() - 1);
        }
        return;
    }
}