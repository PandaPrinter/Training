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
    public int rob(TreeNode root) {
        
        /*
         // method 1:
         if (root == null) return 0;
         int val = 0;
         if (root.left != null) {
         val += rob(root.left.left) + rob(root.left.right);
         }
         if (root.right != null) {
         val += rob(root.right.left) + rob(root.right.right);
         }
         return Math.max(root.val + val, rob(root.left) + rob(root.right));
         */
        
        // method 2:
        int[] rob = helper(root);
        return Math.max(rob[0], rob[1]);
    }
    private int[] helper(TreeNode root) {
        if (root == null) return new int[2];
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int[] rob = new int[2];
        rob[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        rob[1] = root.val + left[0] + right[0];
        return rob;
    }
    
}