public class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        int len = nums.length;
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k);
        for (int i = 0; i < nums.length; i++) {
            heap.offer(nums[i]);
            if (heap.size() > k) heap.poll();
        }
        return heap.poll();
        
        /*
         // cheating....
         Arrays.sort(nums);
         return nums[nums.length - k];
         */
    }
    
}