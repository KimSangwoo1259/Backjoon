import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        int n = Integer.valueOf(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        String[] num = br.readLine().split(" ");
        for (int i = 0; i < n; i++){
            arr[i] = Integer.valueOf(num[i]);
        }

        dp[0] = arr[0];
        int ans = dp[0];
        for (int i = 1; i < n; i++){
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            ans = Math.max(dp[i], ans);
        }
        int dp2[] = new int[n];
        dp2[n - 1] = arr[n - 1];

        for (int i = n-2; i >= 0; i--){
            dp2[i] = Math.max(dp2[i + 1] + arr[i], arr[i]);
        }


        for (int i = 1; i < n-1; i++){
            ans = Math.max(ans, dp[i - 1] + dp2[i + 1]);
        }
        System.out.println(ans);

    }
}