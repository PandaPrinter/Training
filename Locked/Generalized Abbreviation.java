/**
Write a function to generate the generalized abbreviations of a word.

Example:
Given word = "word", return the following list (order does not matter):
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
**/

public class Solution {
    public List<String> generateAbbreviations(String word) {
    	List<String> res = new ArrayList<>();
    	helper(res, new StringBuilder(word), 0, 0, word.toCharArray());
    	return res;
    }
    private void helper(List<String> list, StringBuilder sb, int pos, int count, char[] arr) {
    	int len = sb.length();
    	if (pos == arr.length) {
    		if (count > 0) sb.append(count);
    		list.add(sb.toString());
    	}
    	else {
    		helper(list, sb, pos + 1, count + 1, arr);
    		if (count > 0) sb.append(count);
    		sb.append(arr[pos]);
    		helper(list, sb, pos + 1, 0, arr);
    	}
    	sb.setLength(len);
    }
}
