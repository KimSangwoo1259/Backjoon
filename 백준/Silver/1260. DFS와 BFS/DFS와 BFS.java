import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    static int n;
    static int m;
    static int v;
    static int[][] graph;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        graph = new int[n+1][n+1];
        visited = new boolean[n + 1];
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        visited[v] = true;
        dfs(v);
        visited = new boolean[n + 1];
        visited[v] = true;
        sb.append("\n");
        bfs(v);
        System.out.println(sb);

    }
    static void dfs(int value) {
        sb.append(value).append(" ");

        for (int i = 1; i <= n; i++){
            if (!visited[i] && graph[value][i] == 1){
                visited[i] = true;
                dfs(i);
            }
        }

    }

    static Queue<Integer> q ;
    static void bfs(int value) {
        q  = new LinkedList<>();
        q.add(value);
        while(!q.isEmpty()){
            int now = q.poll();
            sb.append(now).append(" ");
            for (int i = 1; i <=n; i++){
                if (graph[now][i] == 1 && !visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }



    }



}
