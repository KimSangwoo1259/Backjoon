import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.valueOf(br.readLine());

        int triangle[][] = new int[n+1][n+1];
        int dp[][] = new int[n+1][n+1];


        for (int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++){
                triangle[i][j] = Integer.valueOf(st.nextToken());
            }
        }
        int max = 0; // 합의 최대
//        dp[0][0] = triangle[0][0];
//        for(int i = 1; i < n; i++){
//            for(int j = 0; j <=i; j++){
//                if(j == 0 ){
//                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
//                }
//                else if(j == i){
//                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
//                }
//                else{
//                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
//                }
//                if(i == n-1){ //최대값은 마지막 줄에 있을테니 마지막 줄만 비교
//                    max = Math.max(max, dp[i][j]);
//                }
//            }
//
//        }
        for (int i = 1; i <=n; i++){
            for (int j = 1; j<=n; j++){
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                if(i == n){ //최대값은 마지막 줄에 있을테니 마지막 줄만 비교
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();

    }

}