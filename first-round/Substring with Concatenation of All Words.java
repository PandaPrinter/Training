public class Solution {
    static class TrieNode {
        int value = 0;
        Map<Character, TrieNode> children = new HashMap<>();
    }
    
    TrieNode trie;
    
    public List<Integer> findSubstring(String s, String[] words) {
        trie = buildTrie(words);
        int len = getTotalLength(words);
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i <= s.length() - len; i++) {
            if (isSubString(s, i, i + len)) res.add(i);
        }
        return res;
    }
    
    private int getTotalLength(String[] words) {
        int sum = 0;
        for (String word : words) {
            sum += word.length();
        }
        return sum;
    }
    
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) addWord(root, word);
        return root;
    }
    
    private void addWord(TrieNode root, String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode next = node.children.get(c);
            if (next == null) {
                next = new TrieNode();
                node.children.put(c, next);
            }
            node = next;
        }
        node.value++;
    }
    
    private boolean isSubString(String s, int start, int end) {
        if (start == end) return true;
        TrieNode node = trie;
        for (int i = start; i < end; i++) {
            char c = s.charAt(i);
            if (node.children.get(c) == null) return false;
            node = node.children.get(c);
            if (node.value > 0) {
                node.value--;
                if (isSubString(s, i + 1, end)) {
                    node.value++;
                    return true;
                }
                node.value++;
            }
        }
        return false;
    }
}