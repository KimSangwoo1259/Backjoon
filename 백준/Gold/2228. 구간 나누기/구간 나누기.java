import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    // m개의 구간으 나눠서 구간의 총합을 구해야한다.
    // 나중에 한번 더 풀기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        int[] sum = new int[n + 1];
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i<=n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum[i] = sum[i - 1] + arr[i];
        }
        for (int i = 0; i <=n; i++){
            for (int j = 0; j <=m; j++){
                if (j == 0)
                    dp[i][j] = 0;
                else
                    dp[i][j] = Integer.MIN_VALUE;
            }
        }

        for (int j = 1; j<= m; j++){ //구간 수
            for (int i = 1; i<=n; i++){ //고려할 index
                dp[i][j] = dp[i - 1][j];
                for (int k = 1; k <=i; k++){
                    if (k < 2*j - 1) continue;

                    if (k == 1){
                        if (j == 1)
                            dp[i][j] = Math.max(dp[i][j], sum[i]);
                    }
                    else
                        if (dp[k-2][j-1] != Integer.MIN_VALUE)
                            dp[i][j] = Math.max(dp[k - 2][j - 1] + sum[i] - sum[k - 1], dp[i][j]);

                }
            }
        }


        System.out.println(dp[n][m]);
    }

}
