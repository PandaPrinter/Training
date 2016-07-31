public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        // Deque
        int len = nums.length;
        if (len == 0 || k <= 0) return new int[0];
        int[] res = new int[len - k + 1];
        int index = 0;
        Deque<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < len; i++) {
            while (!queue.isEmpty() && i - queue.peek() >= k) {
                queue.poll();
            }
            while (!queue.isEmpty() && nums[queue.getLast()] <= nums[i]) {
                queue.pollLast();
            }
            queue.offer(i);
            if (i >= k - 1) {
                res[index++] = nums[queue.peek()];
            }
        }
        return res;
        
        
        // PriorityQueue
        int len = nums.length;
        if (len == 0 || k <= 0) return new int[0];
        int[] res = new int[len - k + 1];
        int index = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return nums[i2] - nums[i1];
            }
        });
        
        for (int i = 0; i < len; i++) {
            if (!queue.isEmpty() && i >= k) queue.remove(i - k);
            queue.offer(i);
            if (i >= k - 1) res[index++] = nums[queue.peek()];
        }
        return res;
    }
}