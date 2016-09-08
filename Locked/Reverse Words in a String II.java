/**
Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

The input string does not contain leading or trailing spaces and the words are always separated by a single space.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Could you do it in-place without allocating extra space?
**/

public void reverseWords(char[] s) {
	reverse(s, 0, s.length - 1);
	int j = 0;
	for (int i = 0; i < s.length; i++) {
		if (s[i] == ' ') {
			reverse(s, j, i - 1);
			j = i+1;
		}
	}
	reverse(s, j, s.length - 1);
}
private void reverse(char[] s, int lo, int hi) {
	while (lo < hi) {
		char tmp = s[lo];
		s[lo++] = s[hi];
		s[hi--] = tmp;
	}
}
