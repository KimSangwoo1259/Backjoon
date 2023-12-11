import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.valueOf(br.readLine());

        int[][] job = new int[n + 1][2];
        int[] dp = new int[n + 1];

        StringTokenizer st;

        for (int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            job[i][0] = Integer.valueOf(st.nextToken());
            job[i][1] = Integer.valueOf(st.nextToken());
        }
        for(int i = 1; i <=n; i++){
            int temp = i + job[i][0] - 1;
            dp[i] = Math.max(dp[i - 1], dp[i]);
            if (temp <= n){
                dp[temp] = Math.max(dp[temp], dp[i-1] + job[i][1]);
            }

        }
        System.out.println(dp[n]);




    }
}