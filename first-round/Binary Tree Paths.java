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
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if (root == null) return res;
        helper(res, root, "");
        return res;
    }
    private void helper(List<String> res, TreeNode root, String s) {
        if (root.left == null && root.right == null) {
            s += root.val;
            res.add(s);
            return;
        }
        if (root.left != null) helper(res, root.left, s + root.val + "->");
        if (root.right != null) helper(res, root.right, s + root.val + "->");
    }
    
}