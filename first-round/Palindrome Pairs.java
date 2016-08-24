public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length < 2) return res;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);
                if (isPalindrome(str1)) {
                    String tmp = new StringBuilder(str2).reverse().toString();
                    if (map.containsKey(tmp) && map.get(tmp) != i) {
                        List<Integer> list = new ArrayList<>();
                        list.add(map.get(tmp));
                        list.add(i);
                        res.add(list);
                    }
                }
                
                if (isPalindrome(str2)) {
                    String tmp = new StringBuilder(str1).reverse().toString();
                    if (map.containsKey(tmp) && map.get(tmp) != i && j != words[i].length()) {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(map.get(tmp));
                        res.add(list);
                    }
                }
            }
        }
        return res;
    }
    
    private boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i <= j) {
            if (str.charAt(i++) != str.charAt(j--)) return false;
        }
        return true;
    }
}
