/**
Given a string s, return all the palindromic permutations (without duplicates) of it. 
Return an empty list if no palindromic permutation could be form.

For example:

Given s = "aabb", return ["abba", "baab"].

Given s = "abc", return [].

Hint:

If a palindromic permutation exists, we just need to generate the first half of the string.
To generate all distinct permutations of a (half of) string, use a similar approach from: Permutations II or Next Permutation.
**/

// method 1: 
public class Solution {  
    public List<String> generatePalindromes(String s) {  
    	int[] map = new int[256];
    	for (char c : s.toCharArray) {
    		map[c]++;
    	}
    	int j = 0, count = 0;
    	for (int i = 0; i < 256; i++) {
    		if (count == 0 && map[i] % 2 == 1) {
    			j = i;
    			count++;
    		}
    		else if (map[i] % 2 == 1){
    			return new ArrayList<String>();
    		}
    	}
    	String cur = "";
    	if (j != 0) {
    		cur += (char) j;
    		map[j]--;
    	}
    	List<String> res = new ArrayList<>();
    	DFS(res, cur, map, s.length());
    	return res;
    }
    private void DFS(List<String> res, String s, int[] map, int len) {
    	if (s.length() == len) {
    		res.add(new String(s));
    		return;
    	}
    	for (int i = 0; i < 256; i++) {
    		if (map[i] > 0) {
    			char c = (char) i;
    			map[i] -= 2;
    			DFS(res, c + s + c, map, len);
    			map[i] += 2;
    		}
    	}
    }
}

// method 2:
public class Solution {  
    public List<String> generatePalindromes(String s) { 
    	List<String> res = new ArrayList<>();
    	if (s == null || s.length() == 0) return list;
    	Map<Character, Integer> map = new HashMap<>();
    	int odd = 0;
    	for (char c : s.toCharArray()) {
    		if (!map.containsKey(c)) {
    			map.put(c, 1);
    			odd++;
    		}
    		else {
    			map.get(c)++;
    			if (map.get(c) % 2 == 0) odd--;
    			else odd++;
    		}
    	}
    	if (odd > 1) return res;
    	String s = "";
    	List<Character> list = new ArrayList<>();
    	for (Character c : map.keySet()) {
    		if (map.get(c) % 2 == 1) {
    			s += c;
    			map.get(c)--;
    		}
    		for (int i = 0; i < map.get(c) / 2; i++) {
    			list.add(c);
    		}
    	}
    	helper(list, res, s, new boolean[list.size()], new StringBuilder());
    	return res;
    }
    private void helper(List<Character> list, List<String> res, String s, boolean[] used, StringBuilder sb) {
    	if (sb.length() == list.size()) {
    		res.add(sb.toString() + s + sb.reverse().toString());
    		sb.reverse();
    		return;
    	}
    	for (int i = 0; i < list.size(); i++) {
    		if (i > 0 && list.get(i) == list.get(i-1) && !used[i-1]) continue;
    		if (!used[i]) {
    			used[i] = true;
    			sb.append(list.get(i));
    			helper(list, res, s, used, sb);
    			used[i] = false;
    			sb.deleteCharAt(sb.length() - 1);
    		}
    	}
    }
}
