/**
This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your 
method will be called repeatedly many times with different parameters. How would you optimize it?

Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and 
return the shortest distance between these two words in the list.

For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3. Given word1 = "makes", word2 = "coding", return 1.

Note: You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
**/


public class WordDistance {

	HashMap<String, List<Integer>> map = new HashMap<>();
	public WordDistance(String[] words) {
		for (int i = 0; i < words.length; i++) {
			if (!map.containsKey(words[i])) map.put(words[i], new ArrayList<>());
			map.get(words[i]).add(i);
		}
	}

	public int minDistance(String word1, String word2) {
		List<Integer> list1 = map.get(word1);
		List<Integer> list2 = map.get(word2);
		int dis = Integer.MAX_VALUE;
		int i1 = 0, i2 = 0;
		while (i1 < list1.size() && i2 < list2.size()) {
			int val1 = list1.get(i1);
			int val2 = list2.get(i2);
			dis = Math.min(dis, Math.abs(val1 - val2));
			if (val1 < val2) i1++;
			else i2++;
		}
		return dis;
	}
}
