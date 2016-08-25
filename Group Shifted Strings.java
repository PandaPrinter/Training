public List<List<String>> groupStrings(String[] strings) {
	List<List<String>> res = new ArrayList<>();
	HashMap<String, List<String>> map = new HashMap<>();
	for (int i = 0; i < strings.length; i++) {
		String key = "";
		char start = strings[i].charAt(0);
		int offset = start - 'a';
		for (int j = 1; j < strings.length; j++) {
			key += (strings[i].charAt(j) - offset + 26) % 26;
		}
		if (!map.containsKey(key)) {
			map.put(key, new ArrayList<String>());
		}
		map.get(key).add(strings[i]);
	}

	for (List<String> list : map.values()) {
		Collections.sort(list);
		res.add(list);
	}

	return res;
}
