public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '*' || c == '-') {
                String a = input.substring(0, i);
                String b = input.substring(i + 1);
                List<Integer> aPart = diffWaysToCompute(a);
                List<Integer> bPart = diffWaysToCompute(b);
                for (int ap : aPart) {
                    for (int bp : bPart) {
                        if (c == '+') {
                            res.add(ap+bp);
                        }
                        else if (c == '-') {
                            res.add(ap-bp);
                        }
                        else {
                            res.add(ap*bp);
                        }
                    }
                }
            }
        }
        if (res.size() == 0) res.add(Integer.valueOf(input));
        return res;
    }
    
}