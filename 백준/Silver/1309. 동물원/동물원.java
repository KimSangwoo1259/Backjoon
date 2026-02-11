import java.io.*;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        final int MOD = 9901;
        int[][] dp = new int[n + 1][3]; //0 없음 1 왼쪽 2 오른쪽
        // dp[n][0] = dp[n-1][0] + dp[n-1][1] + dp[n-1] + [2]
        dp[1][0] = 1; dp[1][1] = 1; dp[1][2] = 1;
        for (int i = 2; i <= n; i++){
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;
            dp[i][1] = (dp[i - 1][0] + dp[i-1][2]) % MOD;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
        }

        int ans = Arrays.stream(dp[n]).sum() % MOD;

        System.out.println(ans);

    }

}
// 배치 가능경우, 왼쪽, 오른쪽, x

