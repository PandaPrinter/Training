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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, 1, res);
        return res;
    }
    private void helper(TreeNode node, int level, List<List<Integer>> res) {
        if (node == null) return;
        if (res.size() < level) {
            List<Integer> list = new ArrayList<>();
            list.add(node.val);
            res.add(list);
        }
        else {
            res.get(level - 1).add(node.val);
        }
        helper(node.left, level + 1, res);
        helper(node.right, level + 1, res);
    }
}