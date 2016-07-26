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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        if (root != null) helper(res, root, "");
        return res;
    }
    private void helper(List<String> res, TreeNode node, String s) {
        if (node.left == null && node.right == null) {
            s += node.val;
            res.add(s);
            return;
        }
        s += node.val + "->";
        if (node.left != null) helper(res, node.left, s);
        if (node.right != null) helper(res, node.right, s);
    }
    
}