import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.valueOf(st.nextToken());
        int w = Integer.valueOf(st.nextToken());
        final int INF = 1000000000;
        int[][] sec1 = new int[h + 1][w + 1];
        int[][] sec2 = new int[h + 1][w + 1];
        for (int i = 0; i <= h; i++){
            Arrays.fill(sec1[i], 256);
            Arrays.fill(sec2[i], 256);
        }

        for (int i = 1; i <= h; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= w; j++){
                sec1[i][j] = Integer.valueOf(st.nextToken());
            }
        }
        for (int i = 1; i <= h; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= w; j++){
                sec2[i][j] = Integer.valueOf(st.nextToken());
            }
        }
        int[][] dp = new int[h + 1][w + 1];

        for (int i = 0; i <= h; i++){
            Arrays.fill(dp[i], INF);
        }
        for (int i = 1; i <= w; i++){
            dp[1][i] = (sec1[1][i] - sec2[1][i]) * (sec1[1][i] - sec2[1][i]);
        }
        for (int i = 2; i <= h; i++){
            for (int j = 1; j <= w; j++){
                if (j != w)
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i - 1][j + 1]) + (sec1[i][j] - sec2[i][j]) * (sec1[i][j] - sec2[i][j]);
                else
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + (sec1[i][j] - sec2[i][j]) * (sec1[i][j] - sec2[i][j]);
            }
        }
        System.out.println(Arrays.stream(dp[h]).min().getAsInt());

    }
}
