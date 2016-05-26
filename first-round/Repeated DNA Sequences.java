public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        
        //method 1:
        Set<String> res = new HashSet<>();
        Set<String> words = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            if (!words.contains(s.substring(i, i + 10))) {
                words.add(s.substring(i, i + 10));
            }
            else {
                res.add(s.substring(i, i + 10));
            }
        }
        return new ArrayList<String>(res);
        
        
        //method 2:
        
    }
    
}