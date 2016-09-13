/**
Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.

You may assume each number in the sequence is unique.

Follow up: Could you do it using only constant space complexity?
**/

// method 1:
public boolean verifyPreorder(int[] preorder) {
	Stack<Integer> stack = new Stack<>();
	int min = Integer.MIN_VALUE;
	for (int num : preorder) {
		if (num < min) return false;
		while (!stack.isEmpty() && num > stack.peek()) {
			min = stack.pop();
		}
		stack.push(num);
	}
	return true;
}

// method 2:
public boolean verifyPreorder(int[] preorder) {
	int min = Integer.MIN_VALUE, i = -1;
	for (int num : preorder) {
		if (num < min) return false;
		while (i >= 0 && num > preorder[i]) {
			min = preorder[i--];
		}
		preorder[++i] = num;
	}
	return true;
}

// follow up
public boolean verifyPostorder(int[] postorder) {
	int max = Integer.MAX_VALUE, i = postorder.length;
	for (int j = postorder.length - 1; j >= 0; j--) {
		if (postorder[j] > max) return false;
		while (i <= postorder.length - 1 && postorder[j] > postorder[i]) {
			max = postorder[i++];
		}
		postorder[i--] = postorder[j];
	}
	return true;
}
