public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        helper(res, candidates, target, 0, list, 0);
        return res;
    }
    private void helper(List<List<Integer>> res, int[] arr, int target, int curr, List<Integer> list, int index) {
        if (curr == target) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = index; i < arr.length && target >= arr[i]; i++) {
            if (curr < target) {
                list.add(arr[i]);
                helper(res, arr, target, curr + arr[i], list, i);
                list.remove(list.size() - 1);
            }
        }
    }
    
}