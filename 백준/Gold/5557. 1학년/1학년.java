import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());

        int coin[] = new int[n];
        long dp[][] = new long[n][21];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.valueOf(st.nextToken());
        }
        dp[0][coin[0]] = 1;

        for (int i = 1; i < n-1; i++){
            for (int j = 0; j <= 20; j++){
                if(dp[i-1][j] != 0){
                    int plus = j + coin[i];
                    int minus = j - coin[i];
                    if (plus >=0 && plus <=20){
                        dp[i][plus] += dp[i - 1][j];
                    }
                    if (minus >=0 && minus <=20){
                        dp[i][minus] += dp[i - 1][j];
                    }
                }
            }
        }
        System.out.println(dp[n - 2][coin[n - 1]]);

    }
}
// [3] [11] = ++ // [1] [5] = 3
// dp[n][i] 값은 [n]번째 숫자에서 [i] 값이 될 수 있는 횟수. 따라서 dp[n-1]에서 값을 다찾아서 0이 이 아니라면, 조건에 맞게 더해줌