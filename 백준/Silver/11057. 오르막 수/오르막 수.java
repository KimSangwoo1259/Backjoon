import java.io.*;
import java.util.Arrays;


public class Main {

    //1자리 0 ~ 9
    //2자리 00 ~ 09 11 ~ 19 ...
    // 001 002 ~ 099 111 199
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        final int MOD = 10007;

        int[][] dp = new int[n + 1][10];

        for (int i = 0; i < 10; i++){
            dp[1][i] = 1;
        }

        for (int i = 2; i<=n;i++){
            for (int j = 0; j < 10; j++){
                for (int k = j; k < 10; k++){
                    dp[i][j] = (dp[i][j] + dp[i - 1][k]) % MOD;
                }
            }
        }

        System.out.println(Arrays.stream(dp[n]).sum() % MOD);

    }

}
