import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n+1][10];
        final long MOD = 1_000_000_000;
        for (int i = 1; i <= 9; i++){
            dp[1][i] = 1;
        }
        for (int i = 2; i <=n; i++){
            for (int j = 0; j < 10; j++){
                int left = j - 1;
                int right = j+ 1;
                if (left >= 0){
                    dp[i][j] += (dp[i-1][left]) % MOD;
                }
                if (right < 10){
                    dp[i][j] = (dp[i-1][right] + dp[i][j]) % MOD;
                }
            }
        }

        long ans = 0;

        for (int i = 0; i < 10; i++){
            ans = (ans + dp[n][i]) % MOD;
        }
        System.out.println(ans);


    }
    // 1 2 3 4 5 6 7 8 9  [9개]
    // 10 12 / 21 23 ..... /87 89 / 98 [17개]
    // 101 121 123/ 212 210 232 234 ..../ 876 878 898 / 987 989
    // 뒷자리를 기준으로 해볼까?
}
// 0 -> 1로 부터옴 1 -> 0,2 로 부터 옴