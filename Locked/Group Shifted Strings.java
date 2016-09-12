/**
Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". 
We can keep "shifting" which forms the sequence: "abc" -> "bcd" -> ... -> "xyz".

Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence, return:

[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
**/


public List<List<String>> groupStrings(String[] strings) {
	List<List<String>> res = new ArrayList<>();
	Map<String, List<String>> map = new HashMap<>();
	for (String s : strings) {
		int offset = s.charAt(0) - 'a';
		String key = "";
		for (int i = 0; i < s.length(); i++) {
			char c = (char) (s.charAt(i) - offset);
			if (c < 'a') {
				c += 26;
			}
			key += c;
		}
		if (!map.containsKey(key)) map.put(key, new ArrayList<>());
		map.get(key).add(s);
	}
	for (List<String> list : map.values()) {
		res.add(list);
	}
	return res;
}

