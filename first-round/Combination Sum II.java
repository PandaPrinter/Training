public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, res, new ArrayList<Integer>(), 0);
        return res;
    }
    private void helper(int[] arr, int target, int curr, List<List<Integer>> res, List<Integer> list, int index) {
        if (curr == target) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) continue;
            if (curr < target) {
                list.add(arr[i]);
                helper(arr, target, curr + arr[i], res, list, i + 1);
                list.remove(list.size() - 1);
            }
            else return;
        }
    }
    
}