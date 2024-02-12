import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());

        long[] dp = new long[n+1];
        dp[0] = 1; // dp[2] 값을 위해 설정
        dp[1] = 1;

        final long MOD = 15746L;
        if (n >= 2){
            for (int i = 2; i <= n; i++){
                dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
            }
        }
        System.out.println(dp[n]);

    }
}