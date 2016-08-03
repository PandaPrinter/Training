public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // heap
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        int size = k < matrix.length ? k : matrix.length;
        for (int i = 0; i < size; i++) {
            pq.offer(new Tuple(0, i, matrix[0][i]));
        }
        for (int i = 0; i < k - 1; i++) {
            Tuple t = pq.poll();
            if (t.x == matrix.length - 1) continue;
            pq.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
        }
        return pq.poll().val;
    }
}

class Tuple implements Comparable<Tuple>{
    
    int x, y, val;
    
    public Tuple(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
    
    @Override
    public int compareTo(Tuple t) {
        return this.val - t.val;
    }
    
}


// binary search
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1];
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0;
            for (int i = 0; i < matrix.length; i++) {
                int[] row = matrix[i];
                int left = 0, right = matrix[0].length;
                while (left < right) {
                    int middle = left + (right - left) / 2;
                    if (matrix[i][middle] <= mid) {
                        left = middle + 1;
                    }
                    else {
                        right = middle;
                    }
                }
                count += left;
            }
            if (count < k){
                lo = mid + 1;
            }
            else {
                hi = mid;
            }
        }
        return lo;
    }
}

