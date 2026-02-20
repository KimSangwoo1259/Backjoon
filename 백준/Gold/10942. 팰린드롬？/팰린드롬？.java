import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    // 짝수일때 -> 이전에 펠린 드롬 이었다? dp[i][j] 가 팰린드롬인지 알고싶다. 그러면 dp[i+1][j-1]이 팰린드롬이고 arr[i] == arr[j] 라면 팰린드롬
    // 홀 수 일때 -> 1113111
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++){
            dp[i][i] = 1;
        }
        for (int i = n; i >= 1; i--){
            for (int j = i; j <= n; j++){
                if (i == j)
                    continue;
                else if (Math.abs(i - j)== 1){
                    if (arr[i] == arr[j])
                        dp[i][j] = 1;
                }
                else {
                    if (dp[i+1][j-1] == 1 && (arr[i] == arr[j])){
                        dp[i][j] = 1;
                    }
                }
            }
        }
        int t = Integer.parseInt(br.readLine());

        while(t --> 0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            sb.append(dp[x][y]).append("\n");

        }

        System.out.println(sb);


    }

}

