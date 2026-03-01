import java.io.*;
import java.util.*;


public class Main {


    // 1389
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int ans = 0;
        int ansValue = 10000000;
        int[][] kevin = new int[n + 1][n + 1];
        boolean[][] visited = new boolean[n + 1][n + 1];
        for (int i = 1; i <=n; i++){
            Arrays.fill(kevin[i], 1000);
        }
        Queue<Friend> q = new LinkedList<>();
        while(m --> 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            kevin[a][b] = 1;
            kevin[b][a] = 1;
            if (!visited[a][b] && !visited[b][a]){
                visited[a][b] = true;
                visited[b][a] = true;
                q.add(new Friend(a, b, 1));
                q.add(new Friend(b, a, 1));
            }
        }
        while(!q.isEmpty()){
            Friend now = q.poll();
            kevin[now.a][now.b] = Math.min(now.count, kevin[now.a][now.b]);
            kevin[now.b][now.a] = kevin[now.a][now.b];
            for (int i = 1;  i <= n; i++){
                if (now.b == i)
                    continue;
                if (now.a == i)
                    continue;
                if (!visited[now.a][i] && (kevin[now.b][i] == 1 || kevin[i][now.b] == 1)){
                    visited[now.a][i] = true;
                    q.add(new Friend(now.a, i, now.count + 1));
                }
            }
        }

        for (int i= 1; i <=n; i++){
            int sum = 0;
            for (int j = 1; j <=n; j++){
                if (i==j)
                    continue;
                sum += kevin[i][j];
            }
            if (sum < ansValue){
                ansValue = sum;
                ans = i;
            }
        }

        System.out.println(ans);


    }
    static class Friend{
        int a,b,count;

        public Friend(int a, int b, int count) {
            this.a = a;
            this.b = b;
            this.count = count;
        }
    }

}
