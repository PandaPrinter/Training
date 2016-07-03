public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] flag = new boolean[nums.length];
        helper(res, new ArrayList<Integer>(), 0, nums, flag);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> list, int start, int[] nums, boolean[] flag) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (flag[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !flag[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            flag[i] = true;
            helper(res, list, start + 1, nums, flag);
            flag[i] = false;
            list.remove(list.size() - 1);
        }
    }
    
}