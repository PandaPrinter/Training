/**
Numbers can be regarded as product of its factors. For example,

8 = 2 x 2 x 2;
  = 2 x 4.
Write a function that takes an integer n and return all possible combinations of its factors.

Note:
You may assume that n is always positive.
Factors should be greater than 1 and less than n.
**/

public List<List<Integer>> getFactors(int n) {
	List<List<Integer>> res = new ArrayList<>();
	helper(res, new ArrayList<>(), n, 2);
	return res;
}
private void helper(List<List<Integer>> res, List<Integer> list, int n, int factor) {
	if (n <= 1) {
		if (list.size() > 1) res.add(new ArrayList(list));
		return;
	}
	for (int i = factor; i <= (int) Math.sqrt(n); i++) {
		if (n % i == 0) {
			list.add(i);
			helper(res, list, n/i, i);
			list.remove(list.size() - 1);
		}
	}
}
