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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, res, 1);
        return res;
    }
    private void helper(TreeNode node, List<Integer> res, int level) {
        
        if (level > res.size()) {
            res.add(node.val);
        }
        if (node.right != null) {
            helper(node.right, res, ++level);
            level--;
        }
        if (node.left != null) {
            helper(node.left, res, ++level);
            level--;
        }
        
    }
    
}