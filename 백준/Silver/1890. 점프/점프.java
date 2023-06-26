import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());

        int board[][] = new int[n + 1][n + 1];
        long dp[][] = new long[n + 1][n + 1];
        for (int i = 1; i <=n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                board[i][j] = Integer.valueOf(st.nextToken());
            }
        }
        dp[1][1] = 1;

        for (int i = 1; i <=n; i++){
            for (int j = 1; j<=n; j++){
                if(i == n && j == n)
                    continue;
                if((board[i][j] + j <= n) && dp[i][j] > 0)
                    dp[i][board[i][j] + j] += dp[i][j];
                if(board[i][j] + i <= n && dp[i][j] > 0)
                    dp[board[i][j] + i][j] += dp[i][j];
            }
        }

        System.out.println(dp[n][n]);

    }
}