public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] arr = new int[2];
        int lo = 0, hi = numbers.length - 1;
        while (lo < hi) {
            long val = numbers[lo] + numbers[hi];
            if (val == target) {
                arr[0] = lo + 1;
                arr[1] = hi + 1;
                break;
            }
            else if (val < target) {
                lo++;            
            }
            else {
                hi--;
            }
        }
        return arr;
    }
}
