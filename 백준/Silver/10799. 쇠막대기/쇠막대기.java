import java.io.*;
import java.util.Stack;


public class Main {

    // 1개의 막대기당 레이저 당한 횟수 + 1 개로 나뉘어진다 1개가 3번 레이저르 잘리면 4개가 된다,
    // 막대기의 끝과 레이저의 ()를 어떻게 구분할 것인가?
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] stick = br.readLine().toCharArray();

        int len = stick.length;

        int ans = 0;

        char beforeChar = ' ';
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < len; i++){
            char cur = stick[i];
            if (cur == '('){
                stack.push(cur);
            }
            else {
                stack.pop();
                if (beforeChar == '('){ //레이저
                    ans += stack.size();
                }
                else { // 막대기의 끝
                    ans++;
                }
            }
            beforeChar = cur;
        }

        System.out.println(ans);

    }
}