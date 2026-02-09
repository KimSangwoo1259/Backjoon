import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    //이미 불이 난칸, 혹은 불이 나려는 칸은 못간다. 미리 불을 옮기고 움직이자.
    // 탈출 한다는거는 경계 쪽에 도착을 성공해야하고 그 다음 1초뒤에 가능.


    static class Number {
        int value;
        String command;

        public Number(int value, String command) {
            this.value = value;
            this.command = command;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while (t --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            boolean found = false;
            String answer = "";
            Queue<Number> queue = new LinkedList<>();
            boolean[] visited = new boolean[10000];

            queue.add(new Number(start, ""));
            visited[start] = true;

            while(!queue.isEmpty()){
                Number now = queue.poll();
                if (now.value == target){
                    found = true;
                    answer = now.command;
                    break;
                }
                int value = now.value;

                int d = (value * 2) % 10000;
                int s = (value - 1) >= 0 ? value - 1 : 9999;

                int n4 = value % 10;
                int n3 = (value / 10) % 10;
                int n2 = (value / 100) % 10;
                int n1 = (value / 1000) % 10;

                int l = n2 * 1000 + n3 * 100 + n4 * 10 + n1;
                int r = n4 * 1000 + n1 * 100 + n2 * 10 + n3;

                if (!visited[d]){
                    queue.add(new Number(d, now.command.concat("D")));
                    visited[d] = true;
                }
                if (!visited[s]){
                    queue.add(new Number(s, now.command.concat("S")));
                    visited[s] = true;
                }
                if (!visited[l]){
                    queue.add(new Number(l, now.command.concat("L")));
                    visited[l] = true;
                }
                if (!visited[r]){
                    queue.add(new Number(r, now.command.concat("R")));
                    visited[r] = true;
                }
            }
            if (found){
                bw.write(answer + "\n");
            }

        }
        bw.flush();
        bw.close();

    }
}
