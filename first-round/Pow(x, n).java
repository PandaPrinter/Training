public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] tempArr = s.toCharArray();
            Arrays.sort(tempArr);
            String val = String.valueOf(tempArr);
            if (!map.containsKey(val)) {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(val, list);
            }
            else {
                List<String> list = map.get(val);
                list.add(s);
                map.put(val, list);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }
    
}