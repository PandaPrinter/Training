public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() == 0) {
            return res;
        }
        List<String> curr = new ArrayList<>();
        helper(res, s, curr, 0);
        return res;
    }
    private void helper(List<String> res, String ip, List<String> curr, int index) {
        if (curr.size() > 4) return;
        if (curr.size() == 4 && index == ip.length()) {
            StringBuilder temp = new StringBuilder();
            for (String s : curr) {
                temp.append(s + ".");
            }
            temp = temp.deleteCharAt(temp.length() - 1);
            res.add(String.valueOf(temp));
            return;
        }
        for (int i = 1; i < 4; i++) {
            if (index + i > ip.length()) return;
            String s = ip.substring(index, index + i);
            if ((s.startsWith("0") && s.length() > 1) || (s.length() == 3 && Integer.parseInt(s) >= 256)) {
                return;
            }
            else {
                curr.add(s);
            }
            helper(res, ip, curr, index + i);
            curr.remove(curr.size() - 1);
        }
    }
    
}