/**
Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.

For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
**/

public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
    	List<String> res = new LinkedList<>();
    	int next = lower;
    	for (int i = 0; i < nums.length; i++) {
    		if (nums[i] < next) continue;
    		if (nums[i] == next) {
    			next++;
    			continue;
    		} 
    		res.add(getRange(next, nums[i] - 1));
    		next = nums[i] + 1;
    	}
    	if (next <= upper) res.add(getRange(next, upper));
    	return res;
    }
    private String getRange(int lower, int upper) {
    	return lower == upper ? String.valueOf(lower) : lower + "->" + upper;
    }
}
