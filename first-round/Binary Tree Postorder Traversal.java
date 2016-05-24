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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root);
        return res;
    }
    
    private void helper(List<Integer> res, TreeNode node) {
        if (node.left == null) {
            if (node.right == null) {
                res.add(node.val);
                return;
            }
            else {
                helper(res, node.right);
                res.add(node.val);
                return;
            }
        }
        
        helper(res, node.left);
        if (node.right != null) {
            helper(res, node.right);
        }
        res.add(node.val);
    }
    
}