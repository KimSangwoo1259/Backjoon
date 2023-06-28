import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        long dp[] = new long[n + 1];

        int mod = 10007;

        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++){
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
        }

        System.out.println(dp[n] % mod);

    }
}
// 세로막대기로 시작하는 경우, 가로막대기 2개로 시작하는경우