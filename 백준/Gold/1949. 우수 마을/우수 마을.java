import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
//    우수 마을'로 선정된 마을 주민 수의 총 합을 최대로 해야 한다.
//    마을 사이의 충돌을 방지하기 위해서, 만일 두 마을이 인접해 있으면 두 마을을 모두 '우수 마을'로 선정할 수는 없다. 즉 '우수 마을'끼리는 서로 인접해 있을 수 없다.
//    선정되지 못한 마을에 경각심을 불러일으키기 위해서, '우수 마을'로 선정되지 못한 마을은 적어도 하나의 '우수 마을'과는 인접해 있어야 한다
    static int n;
    static int[] village;
    static boolean[] visited;
    static int[][] dp;
    static List<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        village = new int[n + 1];
        visited = new boolean[n + 1];
         dp = new int[n + 1][2];
        graph = new List[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <=n; i++){
            village[i] = Integer.parseInt(st.nextToken());
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n -1; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);

        }
        dfs(1);
        System.out.println(Math.max(dp[1][0],dp[1][1]));

    }
    static void dfs(int value){
        visited[value] = true;

        dp[value][1] = village[value];
        List<Integer> nearVillage = graph[value];
        for (int v: nearVillage){
            if (!visited[v]){
                visited[v] = true;
                dfs(v);
                dp[value][0] += Math.max(dp[v][0], dp[v][1]);
                dp[value][1] += dp[v][0];
            }
        }

    }

}
