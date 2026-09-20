import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        int answer = 1;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++){
            char now = s.charAt(i);
            if (stack.isEmpty())
                stack.push(now);
            else {
                if (stack.peek() == now){
                    stack.pop();
                }
                else {
                    stack.push(now);
                }
            }
        }
        
        if (!stack.isEmpty())
            answer = 0;

        return answer;
    }
}