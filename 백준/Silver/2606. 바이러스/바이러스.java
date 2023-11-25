import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] graph;
    static boolean[] visited;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        n = Integer.valueOf(br.readLine());
        m = Integer.valueOf(br.readLine());
        graph = new int[n+1][n+1];
        visited = new boolean[n + 1];

        int a;
        int b;
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.valueOf(st.nextToken());
            b = Integer.valueOf(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        count = -1;
        bfs(1);
        System.out.println(count);
    }
    static Queue<Integer> q;
    static void bfs(int node){
        q = new LinkedList<>();
        q.add(node);
        visited[node] = true;
        while (!q.isEmpty()){
            int cur = q.poll();
            count++;
            for (int i = 1; i <= n; i++){
                if (graph[cur][i] == 1 && !visited[i]){
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}