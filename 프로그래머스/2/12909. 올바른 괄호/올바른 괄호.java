import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        int index = 0;  
        
        while(index < s.length()){
            char c = s.charAt(index);
            if(c == '('){
                stack.push(c);
            }
            else {
                if(stack.isEmpty() || stack.peek() != '('){
                    return false;
                }
                else {
                    stack.pop();
                }
            }
            index++;
        }
        if(!stack.isEmpty()){
            return false;
        }
        

        return true;
    }
}