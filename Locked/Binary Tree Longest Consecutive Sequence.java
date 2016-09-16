/**
Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. 
The longest consecutive path need to be from parent to child (cannot be the reverse).

For example,

   1
    \
     3
    / \
   2   4
        \
         5 
Longest consecutive sequence path is 3-4-5, so return 3.

   2
    \
     3
    / 
   2    
  / 
 1 
Longest consecutive sequence path is 2-3,not3-2-1, so return 2.

**/

// 1
public class Solution {
    public int longestConsecutive(TreeNode root) {
    	if (root == null) return 0;
    	if (root.left == null && root.right == null) return 1;
    	int left = longestConsecutive(root.left);
    	int right = longestConsecutive(root.right);
    	if (root.left != null && root.val - root.left.val = 1) left++;
    	if (root.right != null && root.val - root.right.val = 1) right++;
    	return Math.max(left, right);
    }
}

// 2
public class Solution {
    public int longestConsecutive(TreeNode root) {
    	if (root == null) return 0;
    	return helper(root, 0, root.val - 1);
    }
    private int helper(TreeNode node, int len, int val) {
    	if (node == null) return 0;
    	int curLen = node.val - val == 1 ? len + 1 : len;
    	return Math.max(curLen, Math.max(helper(node.left, curLen, node.val), helper(node.right, curLen, node.val)));
    }
}
