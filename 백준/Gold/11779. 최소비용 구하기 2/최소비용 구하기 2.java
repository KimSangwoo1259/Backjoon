import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int dist;
        int cost;

        public Edge(int dist, int cost) {
            this.dist = dist;
            this.cost = cost;
        }
    }

    // 먼저푸는것이 좋은문제가 있다 -> 그거먼저, 근데 그게 없다? 그러면 쉬운문제 부터 풀기.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        final int INF = 2_000_000_000;
        int[] cost = new int[n + 1];
        int[] path = new int[n + 1];
        List<Edge>[] list = new List[n + 1];
        for (int i = 1; i <=n; i++){
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i <=n; i++){
            cost[i] = INF;

        }
        boolean[] visited = new boolean[n + 1];

        int m = Integer.parseInt(br.readLine());

        while(m --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[s].add(new Edge(e, c));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        cost[start] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        pq.offer(new Edge(start, 0));

        while(!pq.isEmpty()){
            Edge now = pq.poll();
            if (cost[now.dist] < now.cost)  continue;
            for (Edge next: list[now.dist]){
                if (cost[next.dist] > cost[now.dist] + next.cost){
                    cost[next.dist] = cost[now.dist] + next.cost;
                    pq.offer(new Edge(next.dist, cost[next.dist]));
                    path[next.dist] = now.dist;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(cost[target]).append("\n");
        Stack<Integer> stack = new Stack<>();

        int now = target;
        while(now != 0){
            stack.push(now);
            now = path[now];
        }
        sb.append(stack.size()).append("\n");
        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);


    }
}

