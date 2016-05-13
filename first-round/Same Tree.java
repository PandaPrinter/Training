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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        /*
         if (p == null || q == null) {
         return p == q;
         }
         else {
         return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
         }
         */
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(p);
        stack.push(q);
        while (!stack.isEmpty()){
            TreeNode one = stack.pop();
            TreeNode two = stack.pop();
            if (one == null && two == null) {
                continue;
            }
            if (one == null || two == null) {
                return false;
            }
            if (one.val == two.val) {
                stack.push(one.left);
                stack.push(two.left);
                stack.push(one.right);
                stack.push(two.right);
            }
            else {
                return false;
            }
        }
        return true;
    }
    
}