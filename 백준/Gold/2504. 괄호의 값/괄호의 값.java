import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = 0;

        String str = br.readLine();

        Stack<Character> stack = new Stack<>();

        char temp;
        char pre;
        int count = 1;
        if (str.charAt(0) == '(' || str.charAt(0) == '[') {
            stack.push(str.charAt(0));
            if (str.charAt(0) == '(')
                count *= 2;
            else
                count *= 3;
        }
        else {
            System.out.println(ans);
            return;
        }
        pre = str.charAt(0);

        for (int i = 1; i < str.length(); i++){
            temp = str.charAt(i);
            if (temp == '('){
                stack.push(temp);
                count  *= 2;

            }
            else if(temp == ')'){
                if (stack.empty() || stack.peek() != '('){
                    System.out.println(0);
                    return;
                }

                else{
                    stack.pop();
                    if (pre == '('){
                        ans += count;
                    }
                    count /= 2;

                }

            }
            else if (temp == '['){
                stack.push(temp);
                count *= 3;
            }
            else{ //temp -> ]
                if (stack.empty() || stack.peek() != '[') {
                    System.out.println(0);
                    return;
                }
                else{
                    stack.pop();
                    if (pre == '['){
                        ans += count;
                    }
                    count /= 3;

                }
            }
            pre = temp;
        }
        if (!stack.empty()) {
            System.out.println(0);
            return;
        }
        System.out.println(ans);
    }
}