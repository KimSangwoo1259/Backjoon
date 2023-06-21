import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.valueOf(br.readLine());

        int stair[] = new int[301];
        int dp[] = new int[301];

        for (int i = 1; i <=n; i++){
            stair[i] = Integer.valueOf(br.readLine());
        }

        dp[1] = stair[1];
        dp[2] = stair[1] + stair[2];
        dp[3] = Math.max(stair[1] + stair[3], stair[2] + stair[3]);

        for (int i = 4; i <= n; i++){
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + stair[i - 1]) + stair[i];
        }
        System.out.println(dp[n]);

    }
}