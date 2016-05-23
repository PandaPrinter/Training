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
    
    /*
     
     //method 1
     private int sum = 0;
     public int sumNumbers(TreeNode root) {
     if (root == null) return 0;
     StringBuilder sb = new StringBuilder();
     helper(root, sb);
     return sum;
     }
     private void helper(TreeNode node, StringBuilder sb) {
     if (node.left == null && node.right == null) {
     sb.append(String.valueOf(node.val));
     sum += Integer.parseInt(sb.toString());
     return;
     }
     
     sb.append(String.valueOf(node.val));
     if (node.left != null) {
     helper(node.left, sb);
     sb.setLength(sb.length() - 1);
     }
     if (node.right != null) {
     helper(node.right, sb);
     sb.setLength(sb.length() - 1);
     }
     }
     
     */
    
    //method 2
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    private int helper(TreeNode node, int sum) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return sum * 10 + node.val;
        return helper(node.left, sum * 10 + node.val) + helper(node.right, sum * 10 + node.val);
    }
    
}