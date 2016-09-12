/**
Given a binary tree, count the number of uni-value subtrees.

A Uni-value subtree means all nodes of the subtree have the same value.

For example:
Given binary tree,
              5
             / \
            1   5
           / \   \
          5   5   5
return 4.

**/

// method 1:
public class Solution {  
	private int count = 0;
    public int countUnivalSubtrees(TreeNode root) {  
    	helper(root);
    	return count;
    }
    private boolean helper(TreeNode node) {
    	if (node == null) return true;
    	boolean left = helper(node.left);
    	boolean right = helper(node.right);
    	if (left && right) {
    		if (node.left != null && node.val != node.left.val) return false;
    		if (node.right != null && node.val != node.right.val) return false;
    		count++;
    		return true;
    	}
    	return false;
    }
}


// method 2:
public class Solution {  
	private int count = 0;
    public int countUnivalSubtrees(TreeNode root) {  
    	if (root == null) return 0;
    	helper(root, root.val);
    	return count;
    }
    private boolean helper(TreeNode node, int val) {
    	if (node == null) return true;
    	boolean left = (node.left, node.val);
    	boolean right = (node.right, node.val);
    	if (left && right) count++;
    	return left && right && node.val == val;
    }
}
