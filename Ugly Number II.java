public class Solution {
    //1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, ...
    // 2, 3, 4,
    public int nthUglyNumber(int n) {
        
        
        // dp
        int[] res = new int[n];
        int factor2 = 2, factor3 = 3, factor5 = 5;
        int i2 = 0, i3 = 0, i5 = 0;
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = Math.min(factor2, Math.min(factor3, factor5));
            if (factor2 == res[i]) factor2 = 2 * res[++i2];
            if (factor3 == res[i]) factor3 = 3 * res[++i3];
            if (factor5 == res[i]) factor5 = 5 * res[++i5];
        }
        return res[n - 1];
        
        
        // heap
        PriorityQueue<Long> queue = new PriorityQueue<Long>();
        queue.offer(1L);
        for (int i = 1; i < n; i++) {
            long val = queue.poll();
            while (!queue.isEmpty() && queue.peek() == val) queue.poll();
            queue.add(2*val);
            queue.add(3*val);
            queue.add(5*val);
        }
        return queue.poll().intValue();
        
    }
    
}