public class Solution {
    public boolean isValidSerialization(String preorder) {
        
        /*
         // method 1:
         String[] arr = preorder.split(",");
         int diff = 1;
         for (String str : arr) {
         diff--;
         if (diff < 0) return false;
         if (!str.equals("#")) diff += 2;
         }
         return diff == 0;
         */
        
        // method 2:
        Stack<String> stack = new Stack<>();
        String[] arr = preorder.split(",");
        for (String str : arr) {
            while (str.equals("#") && !stack.isEmpty() && stack.peek().equals("#")) {
                stack.pop();
                if (stack.isEmpty()) return false;
                stack.pop();
            }
            stack.push(str);
        }
        return stack.size() == 1 && stack.peek().equals("#");
    }
    
}