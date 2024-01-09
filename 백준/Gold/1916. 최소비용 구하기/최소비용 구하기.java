import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.valueOf(br.readLine());
        int m = Integer.valueOf(br.readLine());
        int INF = 1000000000;
        int[][] graph = new int[n + 1][n + 1];
        int[] cost = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++){
            cost[i] = INF;
            for (int j = 0; j <=n; j++){
                graph[i][j] = INF;
            }
        }

        for (int i = 1; i <= m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            int c = Integer.valueOf(st.nextToken());
            if (graph[a][b] > c)
                graph[a][b] = c;
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.valueOf(st.nextToken());
        int end = Integer.valueOf(st.nextToken());

        cost[start] = 0;
        for (int i = 1; i <=n; i++){
            int min = INF;
            int minIndex = -1;
            for (int j = 1; j <=n; j++){
                if (cost[j] < min && !visited[j]){
                    min = cost[j];
                    minIndex = j;
                }
            }
            if (minIndex == -1) break;
            visited[minIndex] = true;
            for (int j = 1; j <= n; j++){
                if (cost[j] > cost[minIndex] + graph[minIndex][j])
                    cost[j] = cost[minIndex] + graph[minIndex][j];
            }

        }
        System.out.println(cost[end]);





    }
}
