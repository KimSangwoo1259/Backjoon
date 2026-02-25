import java.io.*;
import java.util.StringTokenizer;


public class Main {

    // 1 2 4 8 16 32 64 128 256 512 1024 2048

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        final int nLEN = 13;
        final int mLEN = 2001;

        long[][] dp = new long[mLEN][mLEN];

        for (int i = 1; i < mLEN; i++){
            dp[1][i] = i;
        }
        for (int i = 2; i < nLEN; i++){
            for (int j = 1; j < mLEN; j++){
                dp[i][j] += dp[i][j - 1] + dp[i - 1][j / 2];
            }
        }

        while(t --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            sb.append(dp[n][m]).append("\n");

        }
        System.out.println(sb);
    }


}
