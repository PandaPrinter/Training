/**
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Find all strobogrammatic numbers that are of length = n.

For example, Given n = 2, return ["11","69","88","96"].
**/


public List<String> findStrobogrammatic(int n) {
	return helper(n, n);	
}
private List<String> helper(int n, int m) {
	if (n == 0) return new ArrayList<String>(Arrays.asList(""));
	if (n == 1) return new ArrayList<String>(Arrays.asList("0", "1", "8"));
	List<String> list = helper(n - 2, m);
	List<String> res = new ArrayList<>();
	for (String s : list) {
		if (n != m) res.add("0" + s + "0");
		res.add("1" + s + "1");
		res.add("6" + s + "9");
		res.add("9" + s + "6");
		res.add("8" + s + "8");
	}
	return res;
}

public List<String> findStrobogrammatic(int n) {
	List<String> one = Arrays.asList("0", "1", "8"), two = Arrays.asList(""), res = two;
	if (n % 2 == 1) res = one;
	for (int i = n%2+2, i <= n; i+=2) {
		List<String> tmp = new ArrayList<>();
		for (String s : res) {
			if (i != n) tmp.add("0" + s + "0");
			tmp.add("1" + s + "1");
			tmp.add("6" + s + "9");
			tmp.add("9" + s + "6");
			tmp.add("8" + s + "8");
		}
		res = tmp;
	}
	return res;
}

