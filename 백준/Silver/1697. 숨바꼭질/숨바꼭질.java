import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int k;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.valueOf(st.nextToken());
        k = Integer.valueOf(st.nextToken());

        visited = new int[100001];
        visited[n] = 1;
        Queue<Integer> q = new LinkedList<>();

        q.add(n);

        while (!q.isEmpty()){
            int now = q.poll();
            if (now == k){
                System.out.println(visited[now] - 1);
                System.exit(0);
            }
            int[] next = {now - 1, now + 1, 2 * now};

            for (int i = 0; i < 3; i++){
                if (next[i] < 0 || next[i] >100000)
                    continue;
                if (visited[next[i]] == 0) {
                    q.add(next[i]);
                    visited[next[i]] = visited[now] + 1;
                }
            }
        }


    }
}