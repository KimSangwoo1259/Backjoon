import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] list = new List[n + 1];
        boolean[] visited = new boolean[n + 1];
        int[] indegree = new int[n + 1];

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> answer = new LinkedList<>();
        for (int i = 1; i <=n; i++){
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());

            int before = Integer.parseInt(st.nextToken());

            for (int j = 1; j < t; j++){
                int temp = Integer.parseInt(st.nextToken());
                list[before].add(temp);
                indegree[temp]++;
                before = temp;
            }
        }
        for (int i = 1; i <= n; i++){
            if (indegree[i] == 0) queue.offer(i);
        }
        while(!queue.isEmpty()){
            Integer now = queue.poll();
            visited[now] = true;
            answer.add(now);
            if (answer.size() > n){
                System.out.println(0);
                return;
            }
            for (Integer v: list[now]){
                if (visited[v]) continue;
                indegree[v]--;
                if (indegree[v] == 0){
                    queue.add(v);
                }

            }
        }
        for (int i = 1; i <= n; i++){
            if (!visited[i]) {
                System.out.println(0);
                return;
            }
        }

        while(!answer.isEmpty()){
            sb.append(answer.poll()).append("\n");
        }
        System.out.println(sb);






    }
}

