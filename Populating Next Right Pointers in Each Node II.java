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
        TreeLinkNode first = root;
        Queue<TreeLinkNode> list = new LinkedList<>();
        if (first != null) list.add(first);
        while (!list.isEmpty()) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                TreeLinkNode node = list.poll();
                if (i == size - 1) node.next = null;
                else {
                    node.next = list.peek();
                }
                if (node.left != null) list.add(node.left);
                if (node.right != null) list.add(node.right);
            }
        }
    }
    
}



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
        TreeLinkNode first = null; // next level
        TreeLinkNode pre = null; // next level
        TreeLinkNode curr = root; // current level
        while (curr != null) {
            while (curr != null) {
                if (curr.left != null) {
                    if (pre == null) {
                        first = curr.left;
                    }
                    else {
                        pre.next = curr.left;
                    }
                    pre = curr.left;
                }
                if (curr.right != null) {
                    if (pre == null) {
                        first = curr.right;
                    }
                    else {
                        pre.next = curr.right;
                    }
                    pre = curr.right;
                }
                curr = curr.next;
            }
            curr = first;
            pre = null;
            first = null;
        }
    }
}