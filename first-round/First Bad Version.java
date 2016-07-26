/* The isBadVersion API is defined in the parent class VersionControl.
 boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return binarySeach(1, n);
    }
    private int binarySeach(int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        return isBadVersion(start) ? start : end;
    }
    
}