import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    static int n;
    static int m;
    static int[][] graph;
    static boolean[] visited;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        ans = 0;

        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i =1; i <= n; i ++){
            if (visited[i])
                continue;
            ans++;
            q.add(i);
            visited[i] = true;
            while(!q.isEmpty()){
                int now = q.poll();
                for (int j = 1; j <=n; j++){
                    if (!visited[j] && graph[now][j] == 1){
                        q.add(j);
                        visited[j] =true;
                    }
                }
            }
        }
        System.out.println(ans);

    }
}
