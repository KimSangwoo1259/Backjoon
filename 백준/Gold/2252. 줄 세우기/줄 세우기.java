import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        List<Integer>[] lists = new List[n + 1];
        for (int i = 1; i <=n; i++){
            lists[i] = new ArrayList<>();
        }
        int[] indegrees = new int[n + 1];
        int[] check = new int[n + 1];

        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.valueOf(st.nextToken());
            int end = Integer.valueOf(st.nextToken());
            lists[start].add(end);
            indegrees[end]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i<= n; i++){
            if (indegrees[i] == 0)
                q.add(i);
        }
        while (!q.isEmpty()){
            int now = q.poll();
            check[now] = 1;
            bw.write(now + " ");

            for (int next : lists[now]){
                if (check[next] == 1) continue;
                indegrees[next]--;
                if (indegrees[next] == 0){
                    q.add(next);
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
