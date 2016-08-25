/**
Given a string, find the length of the longest substring T that contains at most 2 distinct characters.

For example, Given s = “eceba”,

T is "ece" which its length is 3.
**/

public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
    	int max = 0, start = 0;
    	HashMap<Character, Integer> map = new HashMap<>();
    	for (int i = 0; i < s.length(); i++) {
    		char c = s.charAt(i);
    		if (map.containsKey(c)) {
    			map.put(c, map.get(c) + 1);
    		}
    		else {
    			map.put(c, 1);
    		}

    		if (map.size() > 2) {
    			max = Math.max(max, i - start);
    			while (map.size() > 2) {
    				char ch = s.charAt(start);
    				int count = map.get(ch);
    				if (count > 1) {
    					map.put(ch, count - 1);
    				}
    				else {
    					map.remove(ch);
    				}
    				start++;
    			}
    		}
    	}

    	max = Math.max(max, s.length() - start);
    	return max;
    }
}
