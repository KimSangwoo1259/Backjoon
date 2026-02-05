import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    static class Node {
        int x;
        int count;

        public Node(int x, int count) {
            this.x = x;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        int ans = 0;
        boolean[] visited = new boolean[100001];

        visited[n] = true;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(n, 0));

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.x == k){
                ans = now.count;
                break;
            }
            if (now.x > 0){
                int nx = now.x - 1;
                if (!visited[nx]){
                    visited[nx] = true;
                    q.add(new Node(nx, now.count + 1));

                }
                if (now.x <= 50000){
                    nx = now.x * 2;
                    if (!visited[nx]){
                        visited[nx] = true;
                        q.add(new Node(nx, now.count + 1));
                    }
                }
            }
            if (now.x < 100000){
                int nx = now.x + 1;
                if (!visited[nx]){
                    visited[nx] = true;
                    q.add(new Node(nx, now.count + 1));
                }
            }
        }
        System.out.println(ans);


    }
}
