public List<List<Integer>> verticalOrder(TreeNode root) {
	List<List<Integer>> res = new ArrayList<>();
	if (root == null) return res;
	Map<Integer, List<Integer>> map = new HashMap<>();
	Queue<TreeNode> q1 = new LinkedList<>();
	Queue<Integer> q2 = new LinkedList<>();
	q1.offer(root);
	q2.offer(0);
	int min = 0, max = 0;
	while (!q1.isEmpty()) {
		TreeNode node = q1.poll();
		Integer colNum = q2.poll();
		min = Math.min(min, colNum);
		max = Math.max(max, colNum);
		if (!map.containsKey(colNum)) {
			map.put(colNum, new ArrayList<Integer>());
		}
		map.get(colNum).add(node.label);
		if (node.left != null) {
			q1.offer(node.left);
			q2.offer(colNum - 1);
		}
		if (node.right != null) {
			q1.offer(node.right);
			q2.offer(colNum + 1);
		}
	}

	for (int i = min; i <= max; i++) {
		res.add(map.get(i));
	}

	return res;
}
