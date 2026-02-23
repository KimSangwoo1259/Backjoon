import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    // 인접한 두 수를 더해야 한다.. 그리고 필시적으로 n 개의 숫자가 있다면 n-1번의 연산이 이루어진다.
    // 40 30 30 50
    // 70 60 80
    // dp[i][j] -> i번째 책부터 j까지 책을 합치는 최소 비용
    //dp[1][2] 70 dp[2][3] 60 dp[3][4] -> 80
    //dp[1][3] Math.min(dp[1][1] + dp[2][3],dp[1][2] + dp[3][3]
    // K<=500 이므로 K^3 복잡도 까지 가능. 구간의 크기 별로 반복문 돌리면서 dp 를 정의 해보자구?
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while(t--> 0){
            int k = Integer.parseInt(br.readLine());
            int[] arr = new int[k + 1];
            int[] sum = new int[k + 1];
            int[][] dp = new int[k + 1][k + 1];
            final int MAX = Integer.MAX_VALUE;
            for (int i = 1; i <=k; i++){
                for (int j= 1; j <=k; j++){
                    dp[i][j] = MAX;
                }
            }

            StringTokenizer st = new StringTokenizer(br.readLine());

            // 누적합 및 길이 0일때 계산
            for (int i = 1; i <=k; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                sum[i] += (arr[i] + sum[i - 1]);
                dp[i][i] = 0;
            }


            for (int i = 1; i<= k-1; i++){
                for (int j = 1; j + i<=k; j++){
                    for (int l = 0; l <=i-1; l++){
                        dp[j][j + i] = Math.min(dp[j][j + l] + dp[j + l + 1][j + i] + sum[j + i] - sum[j-1], dp[j][j + i]);
                    }
                }
            }
            sb.append(dp[1][k]).append("\n");
        }



        System.out.println(sb);

    }

}