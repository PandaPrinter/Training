public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        List<Integer> curr = new ArrayList<Integer>();
        helper(nums, res, curr, visited);
        return res;
    }
    private void helper(int[] nums, List<List<Integer>> res, List<Integer> curr, boolean[] visited) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<Integer>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            curr.add(nums[i]);
            visited[i] = true;
            helper(nums, res, curr, visited);
            visited[i] = false;
            curr.remove(curr.size() - 1);
        }
    }
    
}