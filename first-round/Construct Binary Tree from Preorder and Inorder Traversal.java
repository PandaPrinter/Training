/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    /*
     
     // method 1
     public TreeNode buildTree(int[] preorder, int[] inorder) {
     return helper(0, 0, inorder.length - 1, preorder, inorder);
     }
     private TreeNode helper(int preIndex, int inStart, int inEnd, int[] preorder, int[] inorder) {
     if (preIndex + 1 > inorder.length || inStart > inEnd) {
     return null;
     }
     int rootValue = preorder[preIndex];
     TreeNode root = new TreeNode(rootValue);
     int rootIndex = 0;
     for (int i = 0; i < inorder.length; i++) {
     if (inorder[i] == rootValue) {
     rootIndex = i;
     }
     }
     root.left = helper(preIndex + 1, inStart, rootIndex - 1, preorder, inorder);
     root.right = helper(preIndex + rootIndex - inStart + 1, rootIndex + 1, inEnd, preorder, inorder);
     return root;
     }
     
     */
    
    // method 2
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(0, 0, inorder.length - 1, preorder, map);
    }
    private TreeNode helper(int preIndex, int inStart, int inEnd, int[] preorder, HashMap<Integer, Integer> map) {
        if (preIndex > map.size() - 1 || inStart > inEnd) {
            return null;
        }
        int rootValue = preorder[preIndex];
        TreeNode root = new TreeNode(rootValue);
        int rootIndex = map.get(rootValue);
        root.left = helper(preIndex + 1, inStart, rootIndex - 1, preorder, map);
        root.right = helper(preIndex + rootIndex - inStart + 1, rootIndex + 1, inEnd, preorder, map);
        return root;
    }
    
}