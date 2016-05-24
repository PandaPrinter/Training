public class Solution {
    
    /*
     // method 1:
     private final Map<String, List<String>> cache = new HashMap<>();
     
     private boolean containSuffix(String str, Set<String> wordDict) {
     for (int i = 0; i < str.length(); i++) {
     if (wordDict.contains(str.substring(i))) {
     return true;
     }
     }
     return false;
     }
     
     public List<String> wordBreak(String s, Set<String> wordDict) {
     if (cache.containsKey(s)) return cache.get(s);
     List<String> res = new LinkedList<>();
     if (wordDict.contains(s)) res.add(s);
     for (int i = 1; i < s.length(); i++) {
     String left = s.substring(0, i), right = s.substring(i);
     if (wordDict.contains(left)) {
     for (String str : wordBreak(right, wordDict)) {
     res.add(left + " " + str);
     }
     }
     }
     cache.put(s, res);
     return res;
     }
     
     */
    public List<String> wordBreak(String s, Set<String> wordDict) {
        return helper(s, wordDict, new HashMap<String, List<String>>());
    }
    
    private List<String> helper(String s, Set<String> wordDict, HashMap<String, List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        List<String> list = new LinkedList<String>();
        if (s.length() == 0) {
            list.add("");
            return list;
        }
        
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> resList = helper(s.substring(word.length()), wordDict, map);
                for (String str : resList) {
                    list.add(word + (str.isEmpty() ? "" : " ") + str);
                }
            }
        }
        map.put(s, list);
        return list;
    }
    
}