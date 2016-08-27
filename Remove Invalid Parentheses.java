public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> res = new HashSet<>();
        int l = 0, r = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                l++;
            }
            if (c == ')') {
                if (l == 0) r++;
                else l--;
            }
        }
        DFS(res, s, l, r, 0, 0, new StringBuilder());
        return new ArrayList<String>(res);
    }
    
    private void DFS(Set<String> res, String s, int l, int r, int i, int open, StringBuilder sb) {
        if (i == s.length() && l == 0 && r == 0 && open == 0) {
            res.add(sb.toString());
            return;
        }
        if (i == s.length() || l < 0 || r < 0 || open < 0) return;
        char c = s.charAt(i);
        int len = sb.length();
        if (c == '(') {
            DFS(res, s, l - 1, r, i + 1, open, sb);
            DFS(res, s, l, r, i + 1, open + 1, sb.append(c));
        }
        else if (c == ')') {
            DFS(res, s, l, r - 1, i + 1, open, sb);
            DFS(res, s, l, r, i + 1, open - 1, sb.append(c));
        }
        else {
            DFS(res, s, l, r, i + 1, open, sb.append(c));
        }
        
        sb.setLength(len);
    }
}








public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null) return res;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        visited.add(s);
        queue.add(s);
        boolean found = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                if (isValid(str)) {
                    found = true;
                    res.add(str);
                }
                if (!found) {
                    for (int j = 0; j < str.length(); j++) {
                        String tmp = str.substring(0, j) + str.substring(j + 1, str.length());
                        if (!visited.contains(tmp)) {
                            visited.add(tmp);
                            queue.add(tmp);
                        }
                    }
                }
            }
            if (found) {
                return res;
            }
        }
        return res;
    }
    
    private boolean isValid(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') {
                count++;
            }
            if (c == ')' && count-- == 0) {
                return false;
            }
        }
        return count == 0;
    }
}
