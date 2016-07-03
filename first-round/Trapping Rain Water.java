public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int maxWater = 0, maxWaterBot = 0, i = 0;
        while (i < height.length) {
            if (stack.isEmpty() || height[i] <= height[stack.peek()]) {
                stack.push(i++);
            }
            else {
                int bot = stack.pop();
                maxWaterBot = stack.isEmpty() ? 0 : (Math.min(height[stack.peek()], height[i]) - height[bot]) * (i - stack.peek() - 1);
                maxWater += maxWaterBot;
            }
        }
        return maxWater;
    }
    
}