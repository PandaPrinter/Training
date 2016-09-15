/**
Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

Note: If the given node has no in-order successor in the tree, return null.
**/

public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
	TreeNode res = null;
	while (root != null) {
		if (root.val > p.val) {
			res = root;
			root = root.left;
		}
		else root = root.right;
	}
	return res;
}


public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
	if (root == null) return null;
	if (root.val <= p.val) {
		return inorderSuccessor(root.right, p);
	}
	else {
		TreeNode left = inorderSuccessor(root.left, p);
		return left == null ? root : left;
	}
}

public TreeNode inorderPredessor(TreeNode root, TreeNode p) {
	if (root == null) return null;
	if (root.val >= p.val) {
		return inorderSuccessor(root.left, p);
	}
	else {
		TreeNode right = inorderSuccessor(root.right, p);
		return right != null ? right : root;
	}
}
