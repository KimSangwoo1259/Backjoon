import java.io.*;
import java.util.*;



public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();
        long ans = 0; // 결과값이 int 범위를 넘을 수 있으므로 long 사용

        for (int i = 0; i < n; i++) {
            int currentHeight = Integer.parseInt(br.readLine());

            // 1. 현재 건물보다 작거나 같은 건물들은 스택에서 제거 (가려지기 때문)
            while (!stack.isEmpty() && stack.peek() <= currentHeight) {
                stack.pop();
            }

            // 2. 스택에 남아있는 건물들은 현재 건물을 내려다볼 수 있는 건물들임
            ans += stack.size();

            // 3. 현재 건물을 스택에 추가
            stack.push(currentHeight);
        }

        System.out.println(ans);
    }
}