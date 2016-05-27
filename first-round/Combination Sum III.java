public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(k, n, res, list, 0);
        return res;
    }
    
    private void helper(int k, int n, List<List<Integer>> res, List<Integer> list, int num) {
        if (k == 0) {
            if (n == 0) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        
        for (int j = num + 1; j <= 9; j++) {
            list.add(j);
            helper(k - 1, n - j, res, list, j);
            list.remove(list.size() - 1);
        }
    }
    
}