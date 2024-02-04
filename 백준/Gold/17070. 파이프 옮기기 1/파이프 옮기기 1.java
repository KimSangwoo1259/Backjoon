import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());
        int[][] home = new int[n+1][n+1];
        StringTokenizer st;
        int[][][] dp = new int[n+1][n+1][3]; // 0 -> 가로 / 1 -> 세로 / 2-> 대각선
        for (int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++){
                home[i][j] = Integer.valueOf(st.nextToken());
            }
        }
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++){
                if (i == 1 && j == 2){
                    dp[1][2][0] = 1;
                    continue;
                }
                if (home[i][j] != 1){
                    dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2]; // 가로
                    dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];
                    if (home[i-1][j] != 1 && home[i][j-1] != 1){
                        dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                    }
                }
            }
        }


//        for (int i = 1; i <= n; i++){
//            for (int j = 2; j <= n; j++){
//                if (dp[i][j][0] > 0){ // 가로
//                    if (j +1 <= n){
//                        if (home[i][j+1] != 1){
//                            dp[i][j + 1][0] += dp[i][j][0];
//                        }
//                        if (i + 1 <= n){
//                            if (home[i+1][j+1] != 1 && home[i+1][j] != 1 && home[i][j+1] != 1){
//                                dp[i + 1][j + 1][2] += dp[i][j][0];
//                            }
//                        }
//                    }
//                }
//
//                if (dp[i][j][1] > 0){ // 세로
//                    if (i +1 <= n){
//                        if (home[i+1][j] != 1){
//                            dp[i+1][j][1] += dp[i][j][1];
//                        }
//                        if (j + 1 <= n){
//                            if (home[i+1][j+1] != 1 && home[i+1][j] != 1 && home[i][j+1] != 1){
//                                dp[i + 1][j + 1][2] += dp[i][j][1];
//                            }
//                        }
//                    }
//                }
//
//                if (dp[i][j][2] > 0){ // 대각선
//                    if (j +1 <= n){
//                        if (home[i][j] != 1){
//                            dp[i][j + 1][0] += dp[i][j][2];
//                        }
//                        if (i + 1 <= n){
//                            if (home[i+1][j+1] != 1 && home[i+1][j] != 1 && home[i][j+1] != 1){
//                                dp[i + 1][j + 1][2] += dp[i][j][2];
//                            }
//                        }
//                    }
//                    if(i + 1 <= n){
//                        if (home[i+1][j] != 1){
//                            dp[i+1][j][1] += dp[i][j][2];
//                        }
//                    }
//                }
//            }
//        }
        int answer = dp[n][n][0] + dp[n][n][1] + dp[n][n][2];
        System.out.println(answer);
    }
}
