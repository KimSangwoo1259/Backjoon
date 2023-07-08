import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.valueOf(br.readLine());

        long dp[][] = new long[10001][4];

        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;
        for (int i = 4; i <= 10000; i++) {
            dp[i][1] = dp[i - 1][1];
            dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
            dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];

        }
        for (int i = 0; i < t; i++) {
            int n = Integer.valueOf(br.readLine());
            long answer = dp[n][1] + dp[n][2] + dp[n][3];
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();


    }
}
//1) 1 // 2) 1+1, 2 //  3) 1+1+1, 2+1, 3, // 4) 1+1+1+1, 2+2, 2+1+1, 3+1 // 5) 1+1+1+1+1, 2+1+1+1, 2+2+1, 3+1+1, 3+2
// 6) 1+1+1+1+1+1, 2+1+1+1+1 , 2+2+2, 2+2+1+1, 3+1+1+1, 3+2+1, 3+3 // 7) 1 + 3 + 4