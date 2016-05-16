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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return helper(nums, 0, nums.length - 1);
    }
    private TreeNode helper(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int i = (start + end) / 2;
        int value = nums[i];
        TreeNode node = new TreeNode(value);
        node.left = helper(nums, start, i - 1);
        node.right = helper(nums, i + 1, end);
        return node;
    }
    
}