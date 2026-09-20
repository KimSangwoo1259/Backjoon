import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        
        // ( 는 그냥 넣기 
        // ) 라면 먼저 비어있는지 체크, 비어있다면 false, 비어있더라고 peek 가 ( 가 아니라면 false ( 면 pop
        // 다 하고나서 안 비어있으면 false
        
        for (int i = 0; i < s.length(); i++){
            char now = s.charAt(i);
            if (now == '(')
                stack.push(now);
            else{
                if (stack.isEmpty()){
                    answer = false;
                    break;
                }
                if (stack.peek() == '('){
                    stack.pop();
                }
                else {
                    answer = false;
                    break;
                }
            }
        }
        if (!stack.isEmpty())
            answer = false;

        return answer;
    }
}