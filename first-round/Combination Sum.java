public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        if (candidates == null || candidates.length == 0 || target < candidates[0]) {
            return res;
        }
        List<Integer> curr = new ArrayList<Integer>();
        helper(res, curr, candidates, target, 0);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> curr, int[] candidates, int target, int j) {
        if (target == 0) {
            List<Integer> temp = new ArrayList<Integer>(curr);
            res.add(temp);
            return;
        }
        for (int i = j; i < candidates.length; i++) {
            if (candidates[i] > target) {
                return;
            }
            else {
                curr.add(candidates[i]);
                helper(res, curr, candidates, target - candidates[i], i);
                curr.remove(curr.size() - 1);
            }
        }
    }
}