public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        if ((long) numerator * (long) denominator < 0) {
            res.append("-");
        }
        
        Long n = Math.abs(new Long(numerator));
        Long d = Math.abs(new Long(denominator));
        
        res.append(String.valueOf(n/d));
        if (n % d == 0) return String.valueOf(res);
        else res.append(".");
        
        Map<Long, Integer> map = new HashMap<>();
        long r = n % d;
        while (r > 0) {
            if (map.containsKey(r)) {
                int pos = map.get(r);
                res.insert(pos, "(");
                res.append(")");
                break;
            }
            else {
                map.put(r, res.length());
                r = r * 10;
                res.append(String.valueOf(r / d));
                r = r % d;
            }
        }
        return String.valueOf(res);
    }
    
}