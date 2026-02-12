import java.io.*;
import java.util.StringTokenizer;

public class Main {


    //각 난이도에 해당하는 문제가 꼭 한개씩 포함 되어야함.
    // dp[n] 은 난이도 n까지 문제를 골랐을때 최대 문제수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] certain = new int[n + 1];
        int[] ambiguous = new int[n];
        final int MOD = 1_000_000_007;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <=n; i++){
            certain[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i < n; i++){
            ambiguous[i] = Integer.parseInt(st.nextToken());
        }
        long[][] dp = new long[n + 1][3];
        dp[1][0] = certain[1];
        dp[1][1] = ambiguous[1];
        dp[1][2] = 0;

        for (int i = 2; i <= n; i++){
            dp[i][0] = ((dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) * certain[i]) % MOD;
            if (i < n){
                dp[i][1] = ((dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) * ambiguous[i]) % MOD;
            }
            if (ambiguous[i-1] > 0){
                dp[i][2] = ((dp[i - 1][0] + dp[i - 1][2]) * ambiguous[i - 1] + dp[i - 1][1] * (ambiguous[i - 1] - 1)) % MOD;
            }
        }

        long ans = (dp[n][0] + dp[n][2]) % MOD;

        System.out.println(ans);

     }
    //dp[n][0] = (dp[n-1][0] + dp[n-1][1] + dp[n-1][2]) * certain[n]
    //dp[n][1] = (dp[n-1][0] + dp[n-1][1] + dp[n-2][1]) * ambiguous[n]
    //dp[n][2] = (dp[n-1][0] + dp[n-1][2]) * ambiguous[n-1] + (dp[n-1][1]) * (ambiguous[n-1] -1)
}

