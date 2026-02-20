import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int max = 0;
        int[][] arr = new int[n + 1][m + 1];
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i<=n; i++){
            String str = br.readLine();
            for (int j = 1; j <=m; j++){
                int value = Character.getNumericValue(str.charAt(j - 1));
                arr[i][j] = value;
                dp[i][j] = value;
                max = Math.max(max, value);
            }
        }
        for (int i = 1; i <=n-1; i++){
            for (int j = 1; j <=m-1; j++){
                int len = dp[i][j];
                if (len >= 1){
                    if (arr[i+1][j+1] == 1){
                        int temp = 0;
                        for (int k = 0; k < len; k++){
                            if (arr[i+1][j - k] == 1 && arr[i - k][j + 1] == 1){
                                temp++;
                            }
                            else{
                                break;
                            }

                        }

                        dp[i + 1][j + 1] = 1 + temp;
                        max = Math.max(max, dp[i + 1][j + 1]);

                    }
                }
            }
        }
        
        System.out.println(max * max);


    }

}

