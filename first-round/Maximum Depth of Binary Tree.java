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
     
     // method 1
     public int maxDepth(TreeNode root) {
     if (root == null) {
     return 0;
     }
     return helper(root, 1);
     }
     private int helper(TreeNode node, int depth){
     if (node == null) {
     return depth - 1;
     }
     return Math.max(helper(node.left, depth + 1), helper(node.right, depth + 1));
     }
     
     // method 2
     public int maxDepth(TreeNode root) {
     if (root == null) {
     return 0;
     }
     return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
     }
     
     */
    
    // method 3 : iterative
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            count++;
        }
        return count;
    }
}