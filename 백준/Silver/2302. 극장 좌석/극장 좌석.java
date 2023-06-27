import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        int m = Integer.valueOf(br.readLine());
        int dp[] = new int[n + 1];
        int vip[] = new int[m + 1];
        for (int i = 1; i <=m; i++){
            vip[i] = Integer.valueOf(br.readLine());
        }
        dp[0] = 1;
        dp[1] = 1;
        int sum = 1;
        for (int i = 2; i<=n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        for (int i = 1; i<= m; i++){
            if(i == 1)
                sum *= dp[vip[i] - 1];
            else{
                sum *= dp[vip[i] - vip[i - 1] - 1];
            }
        }
        sum *= dp[n - vip[m]];
        System.out.println(sum);

    }

}