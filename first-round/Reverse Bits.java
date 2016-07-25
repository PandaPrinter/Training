public class Solution {
    // you need treat n as an unsigned value
    HashMap<Byte, Integer> map = new HashMap<>();
    public int reverseBits(int n) {
        byte[] byteArr = new byte[4];
        for (int i = 0; i < 4; i++) {
            byteArr[i] = (byte) ((n >>> i*8) & 0xFF);
        }
        int res = 0;
        for (int i = 0; i < 4; i++) {
            res = reverseBit(byteArr[i], res, i);
        }
        return res;
    }
    private int reverseBit(byte b, int res, int j) {
        int value = 0;
        if (map.containsKey(b)) {
            value = map.get(b);
        }
        else {
            for (int i = 0; i < 8; i++) {
                value += ((b >>> i) & 1);
                if (i < 7) {
                    value <<= 1;
                }
            }
            map.put(b, value);
        }
        res += value;
        if (j < 3) res <<= 8;
        return res;
    }
}