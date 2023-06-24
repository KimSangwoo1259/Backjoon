import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());

        int alc[] = new int[n + 1];
        int dp[] = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            alc[i] = Integer.valueOf(br.readLine());

        }
        dp[1] = alc[1];
        if(n>= 2)
            dp[2] = alc[1] + alc[2];
        for (int i = 3; i <=n; i++){
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2], dp[i - 3] + alc[i - 1]) + alc[i]); // 계단 오르기와는 다르게 지금 와인을 마시지 않는 경우도 고려해야함
        }
        System.out.println(dp[n]);


    }
}