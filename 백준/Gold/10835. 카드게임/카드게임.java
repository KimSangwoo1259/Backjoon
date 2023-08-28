import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());

        int left[] = new int[n+1];
        int right[] = new int[n+1];
        right[0] = 2001;
        int dp[][] = new int[n + 1][n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int startPos = 1; // 시작 위치
        for (int i = 1; i <= n; i++){
            left[i] = Integer.valueOf(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++){
            right[i] = Integer.valueOf(st.nextToken());
        }
        for (int i = 1; i <= n ; i++){ // i -> right
            for (int j = startPos; j <=n; j++){ // j -> left
                if(right[i-1] < left[j]) // 이전 오른쪽 카드가 현재 왼쪽보다 작은 경우
                    dp[i][j] = Math.max(dp[i - 1][j], Math.max(dp[i - 1][j - 1], dp[i][j - 1])); // 왼쪽 버리기, 둘다 버리기, 오른쪽 버리기 모두 고려
                else
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i][j - 1]);

            }
            for (int j = startPos; j <=n; j++){
                if(right[i] < left[j])
                    dp[i][j] += right[i];
            }
            if(right[i] >= left[startPos])
                startPos++;
        }
        int max = 0;
        for (int i = 1; i <= n; i++){
            max = Math.max(dp[n][i], max);
            max = Math.max(dp[i][n], max);
        }
        System.out.println(max);

    }
}