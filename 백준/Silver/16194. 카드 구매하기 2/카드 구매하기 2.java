import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());

        int card[] = new int[n+1];
        int dp[] = new int[n + 1];
        Arrays.fill(dp, 100000000);
        dp[0] = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++){
            card[i] = Integer.valueOf(st.nextToken());
        }
        dp[1] = card[1];
        for (int i = 2; i <=n; i++){
            for (int j = 1; j <= i; j++){
                dp[i] = Math.min(dp[i], dp[i - j] + card[j]);
            }
        }
        System.out.println(dp[n]);

    }
}