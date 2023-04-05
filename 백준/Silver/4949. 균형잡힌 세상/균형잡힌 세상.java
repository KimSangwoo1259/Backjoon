import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack = new Stack<>();
        List<String> answer = new ArrayList<>();
        String str;
        while(true){
            boolean isChecked = false;
            str = br.readLine();
            if(str.equals("."))
                break;
            char[] a = str.toCharArray();
            for (char temp : a) {
                if(temp == '[' || temp == '(')
                    stack.push(temp);
                else if(temp == ']'){
                    if(stack.empty() || (stack.peek() != '[')){
                        answer.add("no");
                        isChecked = true;
                        break;
                    }
                    else {
                        stack.pop();
                    }
                }
                else if(temp == ')'){
                    if(stack.empty() || (stack.peek() != '(')){
                        answer.add("no");
                        isChecked = true;
                        break;
                    }else {
                        stack.pop();
                    }
                }

            }
            if(isChecked == false) {
                if (stack.empty())
                    answer.add("yes");
                else {
                    answer.add("no");
                }
            }
            stack.clear();
        }
        for (String s : answer) {
            System.out.println(s);
        }


    }
}