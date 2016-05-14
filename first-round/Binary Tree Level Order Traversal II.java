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
     
     // method 1: BFS
     public List<List<Integer>> levelOrderBottom(TreeNode root) {
     List<List<Integer>> result = new ArrayList<>();
     if (root == null) {
     return result;
     }
     helper(root, result, 1);
     return result;
     }
     
     private void helper(TreeNode node, List<List<Integer>> result, int level) {
     int size = result.size();
     if (level > size) {
     List<Integer> list = new ArrayList<Integer>();
     list.add(node.val);
     result.add(0, list);
     }
     else {
     List<Integer> tempList = result.get(size - level);
     tempList.add(node.val);
     }
     if (node.left != null) {
     helper(node.left, result, level + 1);
     }
     if (node.right != null) {
     helper(node.right, result, level + 1);
     }
     }
     
     */
    
    // method 2: DFS
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tempList = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                tempList.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(0, tempList);
        }
        return result;
    }
    
}