import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int curStick = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        int sum = 0;
        char temp;
        while (!stack.empty()){
            temp = stack.pop();
            if (temp == ')'){
                curStick++;
                if (stack.peek() == '('){
                    curStick--;
                    sum += curStick;
                    stack.pop();
                }
            }
            else {
                sum++;
                curStick--;
            }
        }
        System.out.println(sum);
    }
}