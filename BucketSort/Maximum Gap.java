public class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int min = nums[0], max = nums[0];
        for (int i : nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        int gap = (int) Math.ceil((double) (max - min) / (nums.length - 1));
        int[] bucketMin = new int[nums.length - 1];
        int[] bucketMax = new int[nums.length - 1];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        for (int i : nums) {
            if (i == min || i == max) continue;
            int index = (i - min) / gap;
            bucketMin[index] = Math.min(bucketMin[index], i);
            bucketMax[index] = Math.max(bucketMax[index], i);
        }
        int maxGap = Integer.MIN_VALUE;
        int prev = min;
        for (int i = 0; i < nums.length - 1; i++) {
            if (bucketMin[i] == Integer.MAX_VALUE && bucketMax[i] == Integer.MIN_VALUE) continue;
            maxGap = Math.max(maxGap, bucketMin[i] - prev);
            prev = bucketMax[i];
        }
        maxGap = Math.max(maxGap, max - prev);
        return maxGap;
    }
}
