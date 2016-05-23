public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        
        
        //method 1
        List<List<String>> res = new ArrayList<>();
        List<String> initialList = new ArrayList<>();
        initialList.add(beginWord);
        res.add(initialList);
        
        int count = 0;
        boolean flag = true;
        while(res.size() != 0 && flag) {
            Set<String> set = new HashSet<>();
            List<List<String>> tempRes = new ArrayList<>();
            for (int i = 0; i < res.size(); i++) {
                List<String> curr = res.get(i);
                String currWord = curr.get(curr.size() - 1);
                for (int j = 0; j < currWord.length(); j++) {
                    char[] chars = currWord.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[j] = c;
                        String newStr = new String(chars);
                        if (newStr.equals(endWord)) {
                            flag = false;
                            List<String> newList = new ArrayList<>(curr);
                            newList.add(newStr);
                            tempRes.add(0, newList);
                            count++;
                        }
                        else {
                            if (wordList.contains(newStr)) {
                                List<String> newList = new ArrayList<>(curr);
                                newList.add(newStr);
                                tempRes.add(newList);
                                set.add(newStr);
                            }
                        }
                    }
                }
            }
            res = tempRes;
            wordList.removeAll(set);
        }
        
        if (res.size() == 0) return res;
        List<List<String>> finalRes = new ArrayList<>(res.subList(0, count));
        return finalRes;
    }
    
}