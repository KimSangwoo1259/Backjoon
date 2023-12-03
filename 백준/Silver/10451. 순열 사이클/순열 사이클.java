import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.valueOf(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while (t --> 0){
            n = Integer.valueOf(br.readLine());
            st = new StringTokenizer(br.readLine());

            graph = new int[n+1];
            visited = new boolean[n + 1];
            int count = 0;
            for (int i = 1; i <= n; i++){
                graph[i] = Integer.valueOf(st.nextToken());
            }
            for (int i = 1; i <=n; i++){
                if (!visited[i]){
                    dfs(i);
                    count++;
                }
            }
            bw.write(count + "\n");
        }
        bw.flush();
        bw.close();
    }
    static void dfs(int node) {
        visited[node] = true;
        if (!visited[graph[node]])
            dfs(graph[node]);

    }
}