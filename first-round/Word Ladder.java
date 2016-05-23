public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        int length = 1;
        Set<String> reached = new HashSet<String>();
        reached.add(beginWord);
        wordList.add(endWord);
        
        while (!reached.contains(endWord)) {
            Set<String> toAdd = new HashSet<String>();
            for (String wordAdded : reached) {
                for (int i = 0; i < wordAdded.length(); i++) {
                    char[] chars = wordAdded.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String newStr = new String(chars);
                        if (wordList.contains(newStr)) {
                            toAdd.add(newStr);
                            wordList.remove(newStr);
                        }
                    }
                }
            }
            if (toAdd.size() == 0) return 0;
            length++;
            reached = toAdd;
        }
        return length;
    }
    
}