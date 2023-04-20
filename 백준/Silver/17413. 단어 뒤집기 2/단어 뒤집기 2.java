import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] s = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        // 문자가 <,>가 아닌경우 공백이 나올때 까지 스택에 넣은다음 공백이 나오면 들어있던 스택들을 순서대로 다시 출력 후(스택 클리어) 공백을 출력 <,>인경우 그대로 출력
        boolean reverse = true;
        char temp;
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s) {
            if(c == '<'){
                while (!stack.isEmpty()) {
                    stringBuilder.append(stack.peek());
                    stack.pop();
                }
                stringBuilder.append(c);
                reverse = false;
            }
            else if(c == '>'){
                stringBuilder.append(c);
                reverse = true;
            }
            else {
                if (reverse == true) {
                    if (c == ' ') {
                        while (!stack.isEmpty()) {
                            stringBuilder.append(stack.peek());
                            stack.pop();
                        }
                        stringBuilder.append(c);
                    }
                    else {
                        stack.push(c);
                    }
                }
                else {
                    stringBuilder.append(c);
                }
            }
        }
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.peek());
            stack.pop();
        }
        bw.write(stringBuilder.toString());
        bw.flush();
        bw.close();
    }
}