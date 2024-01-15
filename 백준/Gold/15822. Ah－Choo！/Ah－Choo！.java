import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] a = new int[n+1];
        int[] b = new int[n+1];

        for (int i = 1; i <= n; i++){
            a[i] = Integer.valueOf(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++){
            b[i] = Integer.valueOf(st.nextToken());
        }
        int[][] dp = new int[n+1][n+1];
        final int INF = 1000000000;
        for (int i = 0; i <=n; i++){
            for (int j = 0; j <=n; j++){
                dp[i][j] = INF;
            }
        }
        dp[0][0] = 0;
        for (int i = 1; i <=n; i++){
            for (int j = 1; j <= n; j++){
                dp[i][j] = getMin(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + calcDist(a[i], b[j]);
            }
        }
        System.out.println(dp[n][n]);

    }
    static int calcDist(int a, int b){
        return (a - b) * (a - b);
    }
    static int getMin(int a, int b, int c){
        return Math.min(Math.min(a, b), c);
    }
}