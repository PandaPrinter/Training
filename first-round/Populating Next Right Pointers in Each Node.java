/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        /*
         
         // method 1
         while (root != null && root.left != null) {
         TreeLinkNode curr = root;
         while (curr != null) {
         curr.left.next = curr.right;
         curr.right.next = curr.next == null ? null : curr.next.left;
         curr = curr.next;
         }
         root = root.left;
         }
         
         */
        
        // method 2
        if (root == null || root.left == null) return;
        helper(root.left, root.right);
    }
    private void helper(TreeLinkNode node1, TreeLinkNode node2) {
        node1.next = node2;
        if (node1.left != null) {
            helper(node1.left, node1.right);
            helper(node1.right, node2.left);
            helper(node2.left, node2.right);
        }
    }
    
}