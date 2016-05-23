public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) return 0;
        int leftMax = 0;
        int[] leftProfit = new int[len];
        int leftMin = prices[0];
        for (int i = 0; i < len; i++) {
            if (prices[i] < leftMin) leftMin = prices[i];
            if (prices[i] - leftMin > leftMax) leftMax = prices[i] - leftMin;
            leftProfit[i] = leftMax;
        }
        
        int maxProfit = 0;
        int rightMaxProfit = 0;
        int rightMax = prices[len - 1];
        for (int i = len - 1; i >= 0; i--) {
            if (prices[i] > rightMax) rightMax = prices[i];
            if (rightMax - prices[i] > rightMaxProfit) rightMaxProfit = rightMax - prices[i];
            int currentProfit = rightMaxProfit + (i > 0 ? leftProfit[i-1] : 0);
            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
            }
        }
        return maxProfit;
    }
    
}