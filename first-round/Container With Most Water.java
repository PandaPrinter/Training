public class Solution {
    public int maxArea(int[] height) {
        int start = 0, end = height.length - 1;
        int max = 0;
        while (start < end) {
            max = Math.max(max, height[start] < height[end] ? height[start] * (end - start) : height[end] * (end - start));
            if (height[start] == height[end]) {
                start++;
                end--;
            }
            else if (height[start] < height[end]) {
                start++;
            }
            else {
                end--;
            }
        }
        return max;
    }
    
}