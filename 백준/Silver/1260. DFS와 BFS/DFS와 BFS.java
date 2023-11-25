import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static boolean[] visited;
    static BufferedWriter bw;
    static int n;
    static int m;
    static int v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());
        v = Integer.valueOf(st.nextToken());

        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        int a;
        int b;

        for (int i = 1; i <=m; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.valueOf(st.nextToken());
            b = Integer.valueOf(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        dfs(v);
        bw.write("\n");
        visited = new boolean[n + 1];
        bfs(v);
        bw.flush();
        bw.close();
    }
    static void dfs(int node) throws IOException {
        visited[node] = true;
        bw.write(node + " ");
        for (int i = 1; i <= n; i++){
            if (graph[node][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }
    static Queue<Integer> q;
    static void bfs(int node) throws IOException {
        q = new LinkedList<>();
        q.add(node);
        visited[node] = true;
        while (!q.isEmpty()){
            int cur = q.poll();
            bw.write(cur + " ");
            for (int i = 1; i <= n; i++){
                if (graph[cur][i] == 1 && !visited[i]){
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}