import java.util.Stack;

class Solution {
    public String solution(String number, int k) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++){
            int value = Character.getNumericValue(number.charAt(i));


            while(!stack.isEmpty() && stack.peek() < value && k > 0){
                stack.pop();
                k--;
            }

            stack.push(value);
        }
        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb = sb.reverse();
        while(k > 0){
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }
        return sb.toString();
    }
}