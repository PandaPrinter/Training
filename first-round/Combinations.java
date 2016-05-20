public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> element = new ArrayList<Integer>();
        helper(res, element, 1, n, k);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> element, int start, int n, int k) {
        if (k == 0) {
            res.add(new ArrayList<Integer>(element));
            return;
        }
        for (int i = start; i <= n; i++) {
            element.add(i);
            helper(res, element, i + 1, n, k - 1);
            element.remove(element.size() - 1);
        }
    }
    
}