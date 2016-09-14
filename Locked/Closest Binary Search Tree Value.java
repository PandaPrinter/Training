/**
Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note: Given target value is a floating point. You are guaranteed to have only one unique value in the BST that is closest to the target.
**/

// recursive
public class Solution {
    public int closestValue(TreeNode root, double target) {
    	TreeNode kid = root.val < target ? root.right : root.left;
    	if (kid == null) return root.val;
    	int val = closestValue(kid, target);
    	return Math.abs(root.val - target) < Math.abs(val - target) ? root.val : val;
    }
}

// iterative
public class Solution {
    public int closestValue(TreeNode root, double target) {
    	int res = root.val;
    	while (root != null) {
    		res = Math.abs(res - target) < Math.abs(root.val - target) ? res : root.val;
    		if (root.val > target) root = root.left;
    		else root = root.right;
    	}
    	return res;
    }
}
