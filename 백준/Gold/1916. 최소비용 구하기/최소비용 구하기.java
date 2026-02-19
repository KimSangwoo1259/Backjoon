import java.io.*;
import java.util.*;

public class Main {


    // 먼저푸는것이 좋은문제가 있다 -> 그거먼저, 근데 그게 없다? 그러면 쉬운문제 부터 풀기.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        final int INF = 2_000_000_000;
        int[] cost = new int[n + 1];
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 1; i <=n; i++){
            cost[i] = INF;
            for (int j = 1; j <=n; j++){
                graph[i][j] = INF;
            }
        }
        boolean[] visited = new boolean[n + 1];

        int m = Integer.parseInt(br.readLine());

        while(m --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (graph[s][e] > c)
                graph[s][e] = c;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        cost[start] = 0;
        for (int i = 1; i <=n; i++){
            int min = INF;
            int minIndex = -1;
            for (int j = 1; j <= n; j++){
                if (cost[j] < min && !visited[j]){
                    min = cost[j];
                    minIndex = j;
                }
            }
            if (minIndex == -1)
                break;
            visited[minIndex] = true;
            for (int j = 1; j <=n; j++){
                cost[j] = Math.min(cost[j], cost[minIndex] + graph[minIndex][j]);
            }
        }

        System.out.println(cost[target]);


    }
}

