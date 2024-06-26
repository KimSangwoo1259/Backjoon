import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < number.length(); i++) {
            if (stack.isEmpty() || count == k) {
                stack.push(number.charAt(i));
            }
            else{
                int now = Character.getNumericValue(number.charAt(i));
                while (!stack.isEmpty() && count < k){
                    if (Character.getNumericValue(stack.peek()) < now) {
                        stack.pop();
                        count++;
                    } else {
                        break;
                    }
                }
                stack.push(number.charAt(i));

            }
        
        }
        StringBuilder sb = new StringBuilder();

        for(char c : stack){
            sb.append(c);
        }
        
        for (int i = 0; i < k - count; i++){
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }
}