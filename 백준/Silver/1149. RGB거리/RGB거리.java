import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());


        int cost[][] = new int[n+1][3]; //칠하는 비용
        int dp[][] = new int[n + 1][3];
        for (int i = 1; i <=n; i++){
            st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.valueOf(st.nextToken());
            cost[i][1] = Integer.valueOf(st.nextToken());
            cost[i][2] = Integer.valueOf(st.nextToken());
        }
        dp[1][0] = cost[1][0];
        dp[1][1] = cost[1][1];
        dp[1][2] = cost[1][2];
        for (int i = 2; i <=n; i++){
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];

        }
        int min = Arrays.stream(dp[n]).min().getAsInt(); //마지막 열에서 최소값을 찾으면 정답

        System.out.println(min);


    }
}