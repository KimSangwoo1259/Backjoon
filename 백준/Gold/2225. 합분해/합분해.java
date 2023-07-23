import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());
        int k = Integer.valueOf(st.nextToken());
        long mod = 1000000000;
        long dp[][] = new long[n + 1][k+1]; // dp[합한값][합한횟수], value -> 경우의 수
        for (int i = 1; i <=k; i++){
            dp[0][i] = 1;
        }
        for (int i = 1; i <=n; i++){
            for (int j = 1; j<=k; j++){
                if(j == 1)
                    dp[i][j] = 1;
                else{
                    for (int l = 0; l <= i; l++){
                        dp[i][j] = (dp[i][j] + dp[i - l][j - 1]) % mod;
                    }
                }
            }
        }
        System.out.println(dp[n][k]);

    }
}
// 1 0 + 1, 1 + 0 / 0+ 1 + 0, 1+ 0 + 0 / 0 + 0 + 1
//  dp[1][2] =   1 + 0 (dp[1][1] + dp[0][1], 0 + 1 dp[0][1] + dp[1][1]
// dp[2][1] = 1; dp[2][2] = dp[2][1] + dp[1][1] + dp[0][1] // 2 + 0, 1 + 1 , 0 + 2
