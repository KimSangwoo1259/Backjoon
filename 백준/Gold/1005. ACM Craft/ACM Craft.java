import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while(t --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            List<Integer>[] graph = new List[n+1];
            for (int i = 1; i <=n; i++){
                graph[i] = new ArrayList<>();
            }

            int[] time = new int[n + 1];
            int[] dp = new int[n + 1];
            int[] indegree = new int[n + 1];
            Queue<Integer> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <=n; i++){
                time[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < k; i++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                graph[start].add(end);
                indegree[end]++;
            }
            int target = Integer.parseInt(br.readLine());
            for (int i = 1; i<= n; i++){
                if (indegree[i] == 0){
                    queue.offer(i);
                    dp[i] = time[i];
                }
            }
            while(!queue.isEmpty()){
                Integer now = queue.poll();
                for (int v: graph[now]){
                    dp[v] = Math.max(dp[v], dp[now] + time[v]);
                    indegree[v]--;
                    if (indegree[v] == 0){
                        queue.add(v);
                    }
                }
            }

            sb.append(dp[target]).append("\n");
        }
        System.out.println(sb);
    }
}

