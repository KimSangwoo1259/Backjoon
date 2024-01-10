import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.valueOf(br.readLine());
        int m = Integer.valueOf(br.readLine());
        int INF = 1000000000;
        List<Edge>[] graph = new List[n + 1];
        int[] cost = new int[n + 1];
        int[] path = new int[n + 1];

        for (int i = 0; i <= n; i++){
            cost[i] = INF;
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            int c = Integer.valueOf(st.nextToken());
            graph[a].add(new Edge(b, c));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.valueOf(st.nextToken());
        int end = Integer.valueOf(st.nextToken());
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        pq.offer(new Edge(start, 0));
        cost[start] = 0;

        while (!pq.isEmpty()){
            Edge now = pq.poll();
            if (cost[now.dist] < now.cost) continue;
            for (Edge next: graph[now.dist]){
                if (cost[next.dist] > cost[now.dist] + next.cost){
                    cost[next.dist] = cost[now.dist] + next.cost;
                    pq.offer(new Edge(next.dist, cost[next.dist]));
                    path[next.dist] = now.dist;
                }
            }
        }
        System.out.println(cost[end]);
        Stack<Integer> stack = new Stack<>();
        int now = end;
        while (now != 0){
            stack.add(now);
            now = path[now];
        }
        System.out.println(stack.size());

        while (!stack.empty()){
            int tep = stack.pop();
            System.out.print(tep + " ");

        }


    }
}
class Edge{
    int dist;
    int cost;
    Edge(int d, int c) {
        dist = d;
        cost = c;
    }
}