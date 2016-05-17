public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(candidates);
        if (candidates == null || candidates.length == 0 || target < candidates[0]) {
            return new ArrayList<List<Integer>>(res);
        }
        List<Integer> curr = new ArrayList<Integer>();
        helper(candidates, res, curr, target, 0);
        return new ArrayList<List<Integer>>(res);
    }
    private void helper(int[] candidates, Set<List<Integer>> res, List<Integer> curr, int target, int j) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(curr));
            return;
        }
        for (int i = j; i < candidates.length && candidates[i] <= target; i++) {
            curr.add(candidates[i]);
            helper(candidates, res, curr, target - candidates[i], i + 1);
            curr.remove(curr.size() - 1);
        }
    }
    
}