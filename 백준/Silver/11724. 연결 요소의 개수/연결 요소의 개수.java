import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] graph;
    static boolean[] visited;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());

        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        count = 0;
        int a;
        int b;
        for (int i = 1; i <= m; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.valueOf(st.nextToken());
            b = Integer.valueOf(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        for (int i = 1; i <=n; i++){
            if (!visited[i]){
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }
    static void dfs(int node){
        visited[node] = true;
        for (int i = 1; i <= n; i++){
            if (graph[node][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }
}