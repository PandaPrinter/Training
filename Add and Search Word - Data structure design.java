class TrieNode {
    boolean isWord;
    TrieNode[] children = new TrieNode[26];
}

public class WordDictionary {
    
    TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
    }
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        TrieNode cur = root;
        return helper(cur, word);
    }
    
    private boolean helper(TrieNode cur, String word) {
        if (word.isEmpty()) {
            if (cur.isWord) return true;
            else return false;
        }
        
        if (word.charAt(0) == '.') {
            for (int i = 0; i < 26; i++) {
                if (cur.children[i] != null) {
                    boolean res = helper(cur.children[i], word.substring(1));
                    if (res) return true;
                }
            }
            return false;
        }
        
        if (cur.children[word.charAt(0) - 'a'] == null) {
            return false;    
        }
        
        return helper(cur.children[word.charAt(0) - 'a'], word.substring(1));
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
