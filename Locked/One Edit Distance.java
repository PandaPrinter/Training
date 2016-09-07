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




// method 2:

public boolean isOneEditDistance(String s, String t) {
    for (int i = 0; i < Math.min(s.length(), t.length()); i++) { 
    	if (s.charAt(i) != t.charAt(i)) {
    		if (s.length() == t.length()) // s has the same length as t, so the only possibility is replacing one char in s and t
    			return s.substring(i + 1).equals(t.substring(i + 1));
			else if (s.length() < t.length()) // t is longer than s, so the only possibility is deleting one char from t
				return s.substring(i).equals(t.substring(i + 1));	        	
			else // s is longer than t, so the only possibility is deleting one char from s
				return t.substring(i).equals(s.substring(i + 1));
    	}
    }       
    //All previous chars are the same, the only possibility is deleting the end char in the longer one of s and t 
    return Math.abs(s.length() - t.length()) == 1;        
}
