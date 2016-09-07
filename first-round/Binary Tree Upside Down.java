/**
Given a binary tree where all the right nodes are either leaf nodes with a sibling 
(a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree 
where the original right nodes turned into left leaf nodes. Return the new root.
For example:

Given a binary tree {1,2,3,4,5},
    1
   / \
  2   3
 / \
4   5

return the root of the binary tree [4,5,2,#,#,3,1].

   4
  / \
 5   2
    / \
   3   1  
**/


// iterative using stack
public TreeNode upsideDownBinaryTree(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode head = new TreeNode(0);
        TreeNode cur = head;
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            cur.right = node;
            if(!stack.isEmpty())
                node.left = stack.peek().right;
            cur = cur.right;
        }
        return head.right;
    }
    
// recursive
public TreeNode upsideDownBinaryTree(TreeNode root) {
  if (root == null || root.left == null && root.right == null)
    return root;

  TreeNode newRoot = upsideDownBinaryTree(root.left);
  
  root.left.left = root.right;
  root.left.right = root;
  
  root.left = null;
  root.right = null;
      
  return newRoot;
}

// iterative no space
public TreeNode UpsideDownBinaryTree(TreeNode root) { 
	TreeNode cur = null, next = root, right = null;
	while (next != null) {
		TreeNode node = next.left;
		next.left = right;
		right = next.right;
		next.right = cur;
		cur = next;
		next = node;
	}
	return cur;
}
