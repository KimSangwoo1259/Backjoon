import java.util.*;

class Solution {
    public static String solution(String p) {
        StringBuilder answer = new StringBuilder();
        if(p.isEmpty())
            return answer.toString();

        return genString(p);
    }
    public static String genString(String s){
        if (s.isEmpty())
            return s;
        int index = 0;
        int l = 0;
        int r = 0;
        StringBuilder returnString = new StringBuilder();
        String u;
        String v;
        Stack<Character> stack = new Stack<>();

        while(index < s.length()) {
            char cur  = s.charAt(index);
            if(cur == '(') {
                l++;
                stack.push(cur);
            }
            else {
                r++;
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
            }
            index++;
            if (l == r){
                break;
            }
        }
        u = s.substring(0, index);
        v = s.substring(index);
        if (stack.isEmpty()) { // u가 올바른 괄호 문자열
            returnString.append(u);
            if (!v.isEmpty())
                returnString.append(genString(v));
        }
        else { // 올바르지 않아
            returnString.append("(").append(genString(v)).append(")");
            for (int i = 1; i < u.length()-1; i++){
                if (u.charAt(i) ==  '('){
                    returnString.append(")");
                }
                else {
                    returnString.append("(");
                }
            }
        }
        return returnString.toString();
    }
}