import java.io.*;
import java.util.*;

public class Main {


    // 먼저푸는것이 좋은문제가 있다 -> 그거먼저, 근데 그게 없다? 그러면 쉬운문제 부터 풀기.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[] solved = new boolean[n + 1];
        int[] indegree = new int[n + 1];
        List<Integer>[] graph = new List[n + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <=n; i++){
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());

            graph[first].add(next);
            indegree[next]++;
        }
        for (int i = 1; i <= n; i++){
            if (indegree[i] == 0){
                pq.add(i);
            }
        }

        while(!pq.isEmpty()){
            Integer now = pq.poll();
            solved[now] = true;
            sb.append(now).append(" ");

            for (int v: graph[now]){
                if (solved[v])
                    continue;
                indegree[v]--;
                if (indegree[v] == 0)
                    pq.add(v);
            }
        }
        System.out.println(sb);
    }
}

