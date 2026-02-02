import java.io.*;
import java.util.Stack;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] str = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        long ans = 0;
        int roundCount = 0; // ( 의 개수
        int angleCount = 0; // [ 의 개수
        char before = ' ';
        for (int i = 0; i < str.length; i++){
            char curChar = str[i];
            switch (curChar){
                case '(':
                    stack.push(curChar);
                    roundCount++;
                    break;
                case '[':
                    stack.push(curChar);
                    angleCount++;
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != '('){
                        System.out.println(0);
                        return;
                    }
                    stack.pop();
                    roundCount--;
                    if (before == '(') {
                        ans += (long) (2 * Math.pow(2, roundCount) * Math.pow(3, angleCount));
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '['){
                        System.out.println(0);
                        return;
                    }
                    stack.pop();
                    angleCount--;
                    if (before == '[') {
                        ans += (long) (3 * Math.pow(2, roundCount) * Math.pow(3, angleCount));
                    }
                    break;
                default:
                    break;
            }
            before = curChar;

        }
        if (!stack.isEmpty()) {
            System.out.println(0);
            return;
        }

        System.out.println(ans);


    }
}