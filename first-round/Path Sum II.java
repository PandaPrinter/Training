/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(res, curr, root, sum);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> curr, TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        curr.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            res.add(new ArrayList<>(curr));
        }
        else {
            helper(res, curr, root.left, sum - root.val);
            helper(res, curr, root.right, sum - root.val);
        }
        curr.remove(curr.size() - 1);
    }
    
}