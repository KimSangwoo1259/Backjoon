import java.util.Stack;


class Solution {
    public int solution(int[] order) {
        int answer = 0;

        int len = order.length;

        Stack<Integer> stack1 = new Stack<>();

        Stack<Integer> stack2 = new Stack<>();

        for (int i = len; i >= 1; i --){
            stack1.push(i);
        }

        for (int i = 0; i < len; i++){
            int now = order[i];
            if (stack1.isEmpty()){
                if (stack2.peek() == now){
                    answer++;
                    stack2.pop();
                }
                else
                    break;
            }
            else {
               while(!stack1.isEmpty()){
                   if (stack1.peek() == now){
                       stack1.pop();
                       answer++;
                       break;
                   }
                   if (!stack2.isEmpty() && stack2.peek() == now){
                       stack2.pop();
                       answer++;
                       break;
                   }
                   stack2.push(stack1.pop());
               }
                
                
            }
          

        }

        return answer;
    }
}