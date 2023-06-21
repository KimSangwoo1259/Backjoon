import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.valueOf(st.nextToken());
        for (int test = 0; test < t; test++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.valueOf(st.nextToken());
            int sti[][] = new int[2][n + 1]; // 스티커
            int dp[][] = new int[2][n + 1]; // 최대값 저장
            for(int i = 0; i < 2; i ++){
                st = new StringTokenizer(br.readLine());
                for(int j = 1; j <=n; j++){
                    sti[i][j] = Integer.valueOf(st.nextToken());
                }
            }
            dp[0][1] = sti[0][1];
            dp[1][1] = sti[1][1];


            for (int j = 2; j <= n; j++) {
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + sti[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + sti[1][j];
            }
            sb.append(Math.max(dp[0][n], dp[1][n]) + "\n");
        }
        String answer = sb.toString();
        System.out.println(answer);
    }


}