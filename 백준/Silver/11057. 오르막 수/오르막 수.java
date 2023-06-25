import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());
        long dp[][] = new long[1001][10];

        for (int i = 0; i < 10; i ++){
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++){
            for (int j = 0; j <10; j++){
                for (int k = j; k <10; k++){
                    dp[i][j] += dp[i - 1][k];
                }
                dp[i][j] %= 10007;
            }
        }
        int ans = 0;
        for (int i = 0; i < 10; i++){
            ans += dp[n][i];
        }
        System.out.println(ans % 10007);
    }
}
// 0 1 2 3 4 5 6 7 8 9
// 00 01 02 03 04 05 06 08.. / 11~19 / 22~ 29
// 000 001 002