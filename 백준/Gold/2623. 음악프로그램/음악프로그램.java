import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());

        List<Integer>[] lists = new List[n+1];
        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            lists[i] = new ArrayList<>();
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] indegree = new int[n + 1];
        int[] check = new int[n + 1];
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.valueOf(st.nextToken());
            int front = Integer.valueOf(st.nextToken());
            for (int j = 0; j < num -1; j++){
                int end = Integer.valueOf(st.nextToken());
                lists[front].add(end);
                indegree[end]++;
                front = end;
            }
        }
        for (int i = 1; i <= n; i++){
            if (indegree[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()){
            int now = queue.poll();
            check[now] = 1;
            answer.add(now);
            if (answer.size() > n){
                System.out.println(0);
                return;
            }
            for (int next: lists[now]){
                if (check[next] == 1) continue;

                indegree[next]--;
                if (indegree[next] == 0)
                    queue.add(next);
            }
        }
        for (int i = 1; i <= n; i++){
            if (check[i] == 0){
                System.out.println(0);
                return;
            }
        }
        for (int i = 0; i < n; i++){
            bw.write(answer.get(i) + "\n");

        }
        bw.flush();
        bw.close();

    }
}
