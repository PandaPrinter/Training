public class ValidWordAbbr {
	Map<String, String> map;
	public ValidWordAbbr(String[] dictionary) {
		map = new HashMap<>();
		for (String word : dictionary) {
			String key = getKey(word);
			if (map.containsKey(key) && !map.get(key).equals(word)) {
				map.put(key, "");
			}
			else {
				map.put(key, word);
			}
		}
	}

	public boolean isUnique(String word) {
		String key = getKey(word);
		return !map.containsKey(word) || map.get(key).equals(word);
	}

	public String getKey(String word) {
		if (word.length() <= 2) {
			return word;
		}
		return "" + word.charAt(0) + String.valueOf(word.length() - 2) + word.charAt(word.length() - 1); 
	}
}
