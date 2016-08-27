public class Solution {
    public class TreeNode {
        TreeNode left, right;
        int val, count = 1;
        public TreeNode(int val){
            this.val = val;
        }
    }
    
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        TreeNode root = new TreeNode(nums[nums.length - 1]);
        res.add(0);
        for (int i = nums.length - 2; i >= 0; i--) {
            int count = insertNode(root, nums[i]);
            res.add(count);
        }
        Collections.reverse(res);
        return res;
    }
    
    private int insertNode(TreeNode root, int val) {
        int count = 0;
        while (root != null) {
            if (val <= root.val) {
                root.count++;
                if (root.left == null) {
                    TreeNode node = new TreeNode(val);
                    root.left = node;
                    break;
                }
                else {
                    root = root.left;
                }
            }
            else {
                count += root.count;
                if (root.right == null) {
                    TreeNode node = new TreeNode(val);
                    root.right = node;
                    break;
                }
                else {
                    root = root.right;
                }
            }
        }
        return count;
    }
}
