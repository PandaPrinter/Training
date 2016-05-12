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
     public boolean isValidBST(TreeNode root) {
     return helper(root, null, null);
     }
     public boolean helper(TreeNode root, Integer min, Integer max){
     if (root == null) {
     return true;
     }
     if ((min != null && root.val <= min) || (max != null && root.val >= max)){
     return false;
     }
     return helper(root.left, min, root.val) && helper(root.right, root.val, max);
     }
     */
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        TreeNode last = null;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            else {
                TreeNode temp = stack.pop();
                if (last != null && temp.val <= last.val) {
                    return false;
                }
                last = temp;
                cur = temp.right;
            }
        }
        return true;
    }
}