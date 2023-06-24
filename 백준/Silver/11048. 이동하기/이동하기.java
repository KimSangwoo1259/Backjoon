import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());

        int candy[][] = new int[n + 1][m + 1];
        int dp[][] = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= m; j++){
                candy[i][j] = Integer.valueOf(st.nextToken());
            }
        }
        for (int i = 1; i <=n; i++){
            for (int j = 1; j<=m; j++){
                dp[i][j] = Math.max(dp[i - 1][j - 1], Math.max(dp[i - 1][j], dp[i][j - 1])) + candy[i][j];
            }
        }
        System.out.println(dp[n][m]);


    }
}