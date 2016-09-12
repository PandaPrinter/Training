/**
This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.

Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

word1 and word2 may be the same and they represent two individual words in the list.

For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “makes”, word2 = “coding”, return 1. Given word1 = "makes", word2 = "makes", return 3.

Note: You may assume word1 and word2 are both in the list.
**/

// method 1:
public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
    	int index1 = -1, index2 = -1, dis = Integer.MAX_VALUE;
    	for (int i = 0; i < words.length; i++) {
    		if (words[i].equals(word1)) {
    			if (word1.equals(word2)) {
    				if (index1 != -1) dis = Math.min(i - index1);
    				index1 = i;
    				break;
    			} 
    			index1 = i;
    			if (index2 != -1) dis = Math.min(dis, i - index2);
    		}
    		if (words[i].equals(word2)) {
    			index2 = i;
    			if (index1 != -1) dis = Math.min(dis, i - index1);
    		}
    	}	
    	return res;
    }
}

// method 2:

public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
    	int index1 = -1, index2 = -1, dis = Integer.MAX_VALUE, turn = 0, inc = word1.equals(word2) ? 1 : 0;
    	for (int i = 0; i < words.length; i++) {
    		if (words[i].equals(word1) && turn % 2 == 0) {
    			index1 = i;
    			if (index2 != -1) dis = Math.min(dis, i - index2);
    			turn += inc;
    		}
    		else if (words[i].equals(word2)) {
    			index2 = i;
    			if (index1 != -1) dis = Math.min(dis, i - index1);
    			turn += inc;
    		}
    	}	
    	return res;
    }
}
