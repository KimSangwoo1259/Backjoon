import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        List<Integer>[] lists = new List[n + 1];
        int[] indegree = new int[n + 1];
        for (int i = 1; i <=n; i++){
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            lists[a].add(b);
            indegree[b]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i <=n; i++){
            if (indegree[i] == 0) pq.offer(i);
        }
        while (!pq.isEmpty()){
            int now = pq.poll();
            bw.write(now + " ");
            for (int next : lists[now]){
                indegree[next]--;
                if (indegree[next] == 0){
                    pq.offer(next);
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
