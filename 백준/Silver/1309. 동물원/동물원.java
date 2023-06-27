import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        long dp[][] = new long[n + 1][3]; //[n][0] -> 두칸다 없는경우, [n][1] -> 왼쪽만 있는경우, [n][2] -> 오른쪽만 있는경우
        dp[1][0] = 1; dp[1][1] = 1; dp[1][2] = 1;
        int mod = 9901;
        for (int i = 2; i <= n; i++){
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2])  % mod;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % mod;
        }

        System.out.println((dp[n][0] + dp[n][1] + dp[n][2]) % mod);



    }
}