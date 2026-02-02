import java.io.*;
import java.util.*;


public class Main {


    static int[] dp;
    static boolean[] visited;
    static List<Integer>[] tree;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken()); // 루트 번호
        int q = Integer.parseInt(st.nextToken()); //쿼리 수
        tree = new List[n+1];
        dp = new int[n+1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }


        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            tree[x].add(y);
            tree[y].add(x);
        }
        visited[r] = true;
        dp[r] = dfs(r);

        for (int i = 0; i < q; i++) {
            int question = Integer.parseInt(br.readLine());
            bw.write(dp[question] + "\n");
        }

        bw.flush();
        bw.close();

    }

    // dfs 로 서브 트리 수 dp 에 저장 해놓기
    static int dfs(int n) {
        dp[n] = 1;//자기 자신

        for (int i = 0; i < tree[n].size(); i++) {
            int next = tree[n].get(i);
            if (!visited[next]) {
                visited[next] = true;
                dp[n] += dfs(next);
            }
        }
        return dp[n];
    }
}