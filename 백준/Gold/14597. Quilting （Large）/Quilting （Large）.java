import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[][] b1 = new int[h][w];
        int[][] b2 = new int[h][w];
        int[][] dp = new int[h][w];

        for (int i = 0; i < h; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++){
                b1[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < h; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++){
                b2[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < w; i++){
            dp[0][i] = getPow(b1[0][i], b2[0][i]);
        }

        for (int i = 1; i < h; i++){
            for (int j = 0; j < w; j++){
                if (w == 1){
                    dp[i][j] = dp[i - 1][j] + getPow(b1[i][j], b2[i][j]);
                }

                else {
                    if (j == 0) {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + getPow(b1[i][j], b2[i][j]);
                    } else if (j == w - 1) {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + getPow(b1[i][j], b2[i][j]);

                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j + 1])) + getPow(b1[i][j], b2[i][j]);
                    }
                }
            }
        }

        System.out.println(Arrays.stream(dp[h-1]).min().getAsInt());

    }
    static int getPow(int a, int b){
        return (a - b) * (a - b);
    }




}
