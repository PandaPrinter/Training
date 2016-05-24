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
    public List<Integer> preorderTraversal(TreeNode root) {
        /*
         
         // method 1: iterative
         List<Integer> res = new ArrayList<>();
         if (root == null) return res;
         Stack<TreeNode> stack = new Stack<TreeNode>();
         stack.push(root);
         while (!stack.isEmpty()) {
         TreeNode node = stack.pop();
         res.add(node.val);
         if (node.right != null) stack.push(node.right);
         if (node.left != null) stack.push(node.left);
         }
         return res;
         
         */
        
        List<Integer> res = new ArrayList<>();
        helper(res, root);
        return res;
    }
    
    private void helper(List<Integer> res, TreeNode node) {
        if (node == null) {
            return;
        }
        res.add(node.val);
        helper(res, node.left);
        helper(res, node.right);
    }
    
}