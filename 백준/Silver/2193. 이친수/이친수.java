import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        long[][] dp = new long[n+1][2];
        dp[1][1] = 1;
        if (n >= 2){
            for (int i = 2; i <= n; i++){
                dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
                dp[i][1] = dp[i - 1][0];
            }
        }
        System.out.println(dp[n][0] + dp[n][1]);

    }
}