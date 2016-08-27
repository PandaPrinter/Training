public List<List<Integer>> findLeaves(TreeNode root) {
	List<List<Integer>> res = new ArrayList<>();
	if (root == null) return res;
	helper(root, res);
	return res;
}
private int helper(TreeNode node, List<List<Integer>> res) {
	if (node == null) return -1;
	int left = helper(node.left, res) + 1;
	int right = helper(node.right, res) + 1;
	int cur = Math.max(left, right);
	if (res.size() <= cur) {
		res.add(new ArrayList<Integer>());
	}
	res.get(cur).add(node.val);
	return cur;
}
