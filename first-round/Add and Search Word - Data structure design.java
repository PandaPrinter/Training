public class WordDictionary {
    
    private TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode ws = root;
        for (char c : word.toCharArray()){
            if (ws.children[c - 'a'] == null) {
                ws.children[c - 'a'] = new TrieNode();
            }
            ws = ws.children[c - 'a'];
        }
        ws.isWord = true;
    }
    
    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        TrieNode ws = root;
        return helper(word, root);
    }
    
    private boolean helper (String word, TrieNode node) {
        if (word.length() == 0) {
            if (node.isWord) return true;
            return false;
        }
        
        if (word.charAt(0) == '.') {
            for (int j = 'a'; j <= 'z'; j++) {
                if (node.children[j - 'a'] != null) {
                    boolean b = helper(word.substring(1), node.children[j - 'a']);
                    if (b) return true;
                }
            }
            return false;
        }
        
        if (node.children[word.charAt(0) - 'a'] == null) {
            return false;
        }
        
        return helper(word.substring(1), node.children[word.charAt(0) - 'a']);
    }
    
    private class TrieNode {
        boolean isWord;
        TrieNode[] children = new TrieNode[26];
    }
}


// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");