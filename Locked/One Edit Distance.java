public boolean isOneEditDistance(String s, String t) {
	if (s == null || t == null) return false;
	if (s.length() == t.length()) return isOneModified(s, t);
	if (s.length() - t.length() == 1) return isOneDeleted(s, t);
	if (t.length() - s.length() == 1) return isOneDeleted(t, s);
	return false;
}
private boolean isOneModified(String s, String t) {
	int count = 0, ids = 0;
	while (ids < s.length() && count < 2) {
		if (s.charAt(ids) != t.charAt(ids)) count++;
		ids++;
	}
	return count == 1;
}
private boolean isOneDeleted(String s, String t) {
	for (int i = 0; i < t.length(); i++) {
		if (s.charAt(i) != t.charAt(i)) {
			return s.substring(i+1).equals(t.substring(i)); 
		}
	}
	return true;
}
