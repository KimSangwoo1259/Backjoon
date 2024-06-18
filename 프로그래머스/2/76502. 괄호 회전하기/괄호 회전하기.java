import java.util.*;


class Solution {
    public int solution(String s) {
        int answer = 0;
        final int LEN = s.length();
        String[] sList = new String[LEN];
        for (int i = 0; i < LEN; i++) {
            StringBuilder sb = new StringBuilder();
            String front = s.substring(0, i);
            String back = s.substring(i);
            sb.append(back);
            sb.append(front);
            sList[i] = sb.toString();
        }
        
        for(String str : sList){
            if(isRight(str))
                answer++;
        }

        return answer;
    }

    public boolean isRight(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty())
                    return false;
                if (s.charAt(i) == ')') {
                    if (stack.peek() == '(')
                        stack.pop();
                    else
                        return false;
                } else if (s.charAt(i) == '}') {
                    if (stack.peek() == '{')
                        stack.pop();
                    else
                        return false;
                } else if (s.charAt(i) == ']') {
                    if (stack.peek() == '[')
                        stack.pop();
                    else
                        return false;
                }
            }

        }
        return stack.isEmpty();


    }
}