import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int len = numbers.length;
        int[] answer = new int[len];
        answer[len - 1] = -1;
        Stack<Integer> stack = new Stack<>();
        stack.push(numbers[len - 1]);
        
        for (int i = len - 2; i >=0; i--){
            while(!stack.isEmpty()){
                if (numbers[i] < stack.peek()){
                    answer[i] = stack.peek();
                    break;
                }
                else {
                    stack.pop();
                }
            }
            
            if (stack.isEmpty()){
                answer[i] = -1;
            }
            stack.push(numbers[i]);
        }
                
        return answer;
    }

}



