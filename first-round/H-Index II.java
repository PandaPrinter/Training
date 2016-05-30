public class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int low = 0, high = len - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (citations[mid] >= len - mid) {
                if (mid > 0) {
                    if (citations[mid-1] < len - mid + 1) return len - mid;
                    else high = mid - 1;
                }
                else return len - mid;
            }
            else {
                low = mid + 1;
            }
        }
        return 0;
    }
    
}