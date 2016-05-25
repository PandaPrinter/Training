public class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        String[] res = new String[nums.length];
        int index = 0;
        for (int i : nums) {
            res[index++] = String.valueOf(i);
        }
        Arrays.sort(res, new MyComparator());
        if (res[res.length - 1].charAt(0) == '0') return "0";
        StringBuilder sb = new StringBuilder();
        for (int i = res.length - 1; i >= 0; i--){
            sb.append(res[i]);
        }
        return String.valueOf(sb);
    }
    
    class MyComparator implements Comparator<String>{
        public int compare(String s1, String s2) {
            String str1 = s1 + s2;
            String str2 = s2 + s1;
            return str1.compareTo(str2);
        }
    }
}