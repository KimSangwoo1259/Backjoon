import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[][] dp = new int[n][3]; // 0 -> 안먹음 1-> 처음으로 먹음 2-> 연속 두번째로 먹은거임
        // dp[n][0] = dp[n-1] 값 중에 maxxa dp[n][1] = dp[n-1][0] + arr[n] dp[n][2] = dp[n-1][1] + arr[i]
        dp[0][1] = arr[0];
        if (n > 1){
            dp[1][0] = arr[0];
            dp[1][1] = arr[1];
            dp[1][2] = dp[0][1] + arr[1];

            for (int i = 2; i < n; i++){
                dp[i][0] = Math.max(Math.max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]);
                dp[i][1] = dp[i - 1][0] + arr[i];
                dp[i][2] = dp[i - 1][1] + arr[i];
            }
        }

        int ans = Arrays.stream(dp[n - 1]).max().getAsInt();

        System.out.println(ans);


    }


}

