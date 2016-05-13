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
    public List<List<Integer>> levelOrder(TreeNode root) {
        /*
         List<List<Integer>> result = new ArrayList<>();
         if (root == null) {
         return result;
         }
         helper(root, result, 1);
         return result;
         }
         private void helper(TreeNode node, List<List<Integer>> result, int depth) {
         if (node == null) {
         return;
         }
         if (result.size() < depth) {
         List<Integer> temp = new ArrayList<Integer>();
         temp.add(node.val);
         result.add(temp);
         }
         else {
         List<Integer> temp = result.get(depth - 1);
         temp.add(node.val);
         }
         helper(node.left, result, depth + 1);
         helper(node.right, result, depth + 1);
         */
        
        // Using Queue
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                temp.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(temp);
        }
        return result;
    }
}