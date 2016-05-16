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
    public int minDepth(TreeNode root) {
        
        /*
         
         // method 1:
         if (root == null) {
         return 0;
         }
         int left = minDepth(root.left);
         int right = minDepth(root.right);
         if (left != 0 && right != 0) {
         return Math.min(left, right) + 1;
         }
         else {
         return left + right + 1;
         }
         
         */
        
        // method 2:
        if (root == null) {
            return 0;
        }
        return helper(root, 1);
    }
    private int helper(TreeNode root, int depth){
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        if (root.left == null && root.right == null) {
            return depth;
        }
        else {
            return Math.min(helper(root.left, depth + 1), helper(root.right, depth + 1));
        }
    }
}
