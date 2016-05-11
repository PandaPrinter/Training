public class Solution {
    List<Integer> list = new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversalHelper(root);
        }
        return list;
    }
    public void inorderTraversalHelper(TreeNode root){
        if (root.left != null) {
            inorderTraversalHelper(root.left);
            list.add(root.val);
            if (root.right != null){
                inorderTraversalHelper(root.right);
            }
        }
        else {
            list.add(root.val);
            if (root.right != null){
                inorderTraversalHelper(root.right);
            }
        }
    }
}