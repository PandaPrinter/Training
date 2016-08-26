private Map<String, Integer> lookup = new HashMap<>();
public boolean shouldPrintMessage(int timestamp, String message) {
	if (lookup.containsKey(message) && (timestamp - lookup.get(message)) < 10) {
		return false;
	}
	lookup.put(message, timestamp);
	return true;
}
