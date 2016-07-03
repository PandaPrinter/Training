public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, res, 0);
        return res;
    }
    private void helper(int[] nums, List<List<Integer>> res, int index) {
        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i : nums) {
                list.add(i);
            }
            res.add(list);
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            helper(nums, res, index + 1);
            swap(nums, i, index);
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    
    // method 2:
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> list = new ArrayList<>();
            for (List<Integer> l : res) {
                for (int j = 0; j < l.size() + 1; j++) {
                    List<Integer> temp = new ArrayList<>(l);
                    temp.add(j, nums[i]);
                    list.add(temp);
                }
            }
            res = new ArrayList<>(list);
        }
        return res;
    }
}