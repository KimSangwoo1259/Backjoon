import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken()); // 표의 크기
        int m = Integer.valueOf(st.nextToken());

        int table[][] = new int[n+1][n+1];

        int dp[][] = new int[n+1][n+1]; //누적 합 값

        for (int i = 1; i < n + 1; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                table[j][i] = Integer.valueOf(st.nextToken());
            }
        }
        for (int i = 1; i < n + 1; i ++) {
            for (int j = 1; j < n + 1; j++) {
                dp[j][i] = dp[j - 1][i] + dp[j][i - 1] - dp[j - 1][i - 1] + table[j][i];
            }
        }
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.valueOf(st.nextToken());
            int y1 = Integer.valueOf(st.nextToken());
            int x2 = Integer.valueOf(st.nextToken());
            int y2 = Integer.valueOf(st.nextToken());
            int ans = dp[y2][x2] - dp[y1 - 1][x2] - dp[y2][x1 - 1] + dp[y1 - 1][x1 - 1];
            bw.write(ans + "\n");
        }
        bw.flush();
        bw.close();

    }
}