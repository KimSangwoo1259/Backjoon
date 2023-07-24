import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());
        int k = Integer.valueOf(st.nextToken());
        int coin[] = new int[n+1];
        int dp[] = new int[k+1]; // 금액에 대한 경우의 수를 담음
        dp[0] = 1;
        for (int i = 1; i <= n; i++){
            coin[i] = Integer.valueOf(br.readLine());
        }
        Arrays.sort(coin);
        for (int i = 1; i <=n; i++){
            for (int j = coin[i]; j <= k; j++){
                if(j - coin[i] >= 0)
                    dp[j] += dp[j - coin[i]];
            }
        }
        System.out.println(dp[k]);
    }
}