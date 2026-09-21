import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder(s);
        
        for (int i = 0; i < sb.length(); i++){
            if (isCorrect(sb.toString()))
                answer++;

            char left = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(left);
        }
        
        return answer;
    }
    
    public boolean isCorrect(String s){
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++){
            char now = s.charAt(i);
            
            if (stack.isEmpty()){
                stack.push(now);
            }
            else {
                if (now == ')'){
                    if (stack.peek() == '('){
                        stack.pop();
                    }
                    else {
                        return false;
                    }
                }
                else if (now == '}'){
                    if (stack.peek() == '{'){
                        stack.pop();
                    }
                    else {
                        return false;
                    }
                }
                else if (now == ']'){
                    if (stack.peek() == '['){
                        stack.pop();
                    }
                    else {
                        return false;
                    }
                }
                else {
                    stack.push(now);
                }
            }
        }
        return stack.isEmpty();

    }
}
