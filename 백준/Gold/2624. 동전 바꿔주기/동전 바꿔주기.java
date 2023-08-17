import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 20 = 10×2
 * 20 = 10×1 + 5×2
 * 20 = 10×1 + 5×1 + 1×5
 * 20 = 5×3 + 1×5
 * 입력으로 지폐의 금액 T, 동전의 가지 수 k, 각 동전 하나의 금액 pi와 개수 ni가 주어질 때 (i=1, 2,…, k)
 * 지폐를 동전으로 교환하는 방법의 가지 수를 계산하는 프로그램을 작성하시오. 방법의 수는 231-1을 초과 하지 않는 것으로 가정한다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int t = Integer.valueOf(br.readLine()); // 지폐의 금액
        int k = Integer.valueOf(br.readLine()); // 가지수

        int coin[][] = new int[k+1][2]; // [k][0] = 동전 가격 [k][1] = 동전 개수

        for (int i = 1; i <= k; i++){
            st = new StringTokenizer(br.readLine());
            coin[i][0] = Integer.valueOf(st.nextToken());
            coin[i][1] = Integer.valueOf(st.nextToken());
        }
        int dp[][] = new int[k+1][t+1];
        dp[0][0] = 1;
        for (int i = 1; i <= k; i++){
            for (int j = 0; j<=coin[i][1]; j++){
                for (int l = 0+(j*coin[i][0]); l <=t; l++){
                    dp[i][l] += dp[i - 1][l - (j * coin[i][0])];
                }
            }
        }
        System.out.println(dp[k][t]);
    }
}