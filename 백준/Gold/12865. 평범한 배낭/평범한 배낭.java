import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());
        int k = Integer.valueOf(st.nextToken());

        int[] dp = new int[k + 1];

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.valueOf(st.nextToken());
            int v = Integer.valueOf(st.nextToken());

            for (int j = k; j >= w; j--){
                dp[j] = Math.max(dp[j], dp[j - w] + v);
            }
        }
        System.out.println(dp[k]);
    }
}