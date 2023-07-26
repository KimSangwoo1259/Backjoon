import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());


        int square[][] = new int[n+1][m+1];
        int dp[][] = new int[n+1][m+1];
        for (int i = 1; i <= n; i++){
            String s = br.readLine();
            for (int j = 1; j <= m; j++){
                square[i][j] = Character.getNumericValue(s.charAt(j-1));
            }
        }
        int max = 0;
        for (int i = 1; i <=n; i++){
            for (int j = 1; j <=m; j++){
                if(square[i][j] == 1){
                    dp[i][j] = 1;
                    if (dp[i-1][j-1] >= 1){
                        for (int k = 1; k <= dp[i-1][j-1]; k++){
                            if (square[i-k][j] <1 || square[i][j-k] < 1){
                                break;
                            }
                            else {
                                dp[i][j]++;
                            }
                        }

                    }
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        System.out.println(max * max);

    }
}