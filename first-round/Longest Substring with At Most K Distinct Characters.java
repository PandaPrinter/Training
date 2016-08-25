/**
Given a string, find the longest substring that contains only two unique characters. For example, 
given "abcbbbbcccbdddadacb", the longest substring that contains 2 unique character is "bcbbbbcccb".
**/

public int lengthOfLongestSubstringTwoDistinct(String s) {
	Map<Character, Integer> map = new HashMap<>();
	int start = 0, max = 0;
	for (int i = 0; i < s.length(); i++) {
		char c = s.charAt(i);
		if (!map.containsKey(c)) {
			map.put(c, 1);
		}
		else {
			map.put(c, map.get(c) + 1);	
		}
		if (map.size() > 2) {
			max = Math.max(max, i - start);
			while (map.size() > 2) {
				char ch = s.charAt(start);
				int fre = map.get(ch);
				if (fre == 1) {
					map.remove(ch);
				}
				else {
					map.put(ch, fre - 1);
				}
				start++;
			}
		}
	}

	return Math.max(max, s.length() - start);
}
