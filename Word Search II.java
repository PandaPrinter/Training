class TrieNode {
    boolean isWord;
    String word;
    TrieNode[] children = new TrieNode[26];
}

public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();       
        TrieNode root = new TrieNode(); 
        for (String word : words) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.word = word;
            cur.isWord = true;
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                backTrack(root, board, res, i, j);
            }
        }
        return res;
    }
    
    private void backTrack(TrieNode root, char[][] board, List<String> res, int i, int j) {
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1) return;
        char c = board[i][j];
        if (board[i][j] == '#' || root.children[c - 'a'] == null) return;
        root = root.children[c - 'a'];
        if (root.isWord) {
            res.add(root.word);
            root.isWord = false;
        }
        board[i][j] = '#';
        backTrack(root, board, res, i - 1, j);
        backTrack(root, board, res, i + 1, j);
        backTrack(root, board, res, i, j - 1);
        backTrack(root, board, res, i, j + 1);
        board[i][j] = c;
    }
}
