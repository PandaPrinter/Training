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
     
     // method 1:
     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
     List<List<Integer>> result = new ArrayList<>();
     if (root == null) {
     return result;
     }
     helper(result, root, 1);
     return result;
     }
     private void helper(List<List<Integer>> result, TreeNode node, int depth) {
     if (node == null) {
     return;
     }
     if (result.size() < depth) {
     List<Integer> list = new ArrayList<Integer>();
     list.add(node.val);
     result.add(list);
     }
     else {
     if (depth % 2 == 0) {
     List<Integer> tempList = result.get(depth - 1);
     tempList.add(0, node.val);
     }
     else {
     List<Integer> tempList = result.get(depth - 1);
     tempList.add(node.val);
     }
     }
     helper(result, node.left, depth + 1);
     helper(result, node.right, depth + 1);
     }
     */
    
    // method 2:
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> tempList = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (count % 2 == 0) {
                    tempList.add(node.val);
                }
                else {
                    tempList.add(0, node.val);
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(tempList);
            count++;
        }
        return result;
    }
}