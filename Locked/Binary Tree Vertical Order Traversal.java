/**
Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
 

return its vertical order traversal as:

[
  [9],
  [3,15],
  [20],
  [7]
]
 

Given binary tree [3,9,20,4,5,2,7],

    _3_
   /   \
  9    20
 / \   / \
4   5 2   7
 

return its vertical order traversal as:

[
  [4],
  [9],
  [3,5,2],
  [20],
  [7]
]
**/

public List<List<Integer>> verticalOrder(TreeNode root) {    
	List<List<Integer>> res = new ArrayList<>();
	Map<Integer, List<Integer>> map = new HashMap<>();
	Queue<TreeNode> queue = new LinkedList<>();
	Queue<Integer> level = new LinkedList<>();
	queue.offer(root);
	level.offer(0);
	int min = 0, max = 0;
	while (!queue.isEmpty()) {
		TreeNode node = queue.poll();
		int l = level.poll();
		if (!map.containsKey(l)) {
			map.put(l, new ArrayList<>());
		}
		map.get(l).add(node.val);
		if (node.left != null) {
			queue.offer(node.left);
			level.offer(l-1);
			if (l-1 < min) min = l-1; 
		}
		if (node.right != null) {
			queue.offer(node.right);
			level.offer(l+1);
			if (l+1 > max) max = l+1;
		}
	}
	for (int i = min; i <= max; i++) {
		res.add(map.get(i));
	}
	return res;
}
