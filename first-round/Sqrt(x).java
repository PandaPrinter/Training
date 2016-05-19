public class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int min = 1, max = Integer.MAX_VALUE;
        while (true) {
            int mid = min + (max - min) / 2;
            if (mid > x / mid) {
                max = mid - 1;
            }
            else {
                if (mid + 1 > x / (mid + 1)) {
                    return mid;
                }
                min = mid + 1;
            }
        }
    }
    
}