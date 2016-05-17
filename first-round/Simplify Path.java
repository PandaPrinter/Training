public class Solution {
    public String simplifyPath(String path) {
        String[] pathArr = path.split("/");
        Stack<String> stack = new Stack<String>();
        for (String e : pathArr) {
            if (e.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else if (!e.equals("") && !e.equals(".")){
                stack.push(e);
            }
        }
        String resPath = "";
        for(String s : stack){
            resPath = resPath + s + "/";
        }
        resPath = "/" + resPath;
        if (!stack.isEmpty()) {
            resPath = resPath.substring(0, resPath.length() - 1);
        }
        return resPath;
    }
}