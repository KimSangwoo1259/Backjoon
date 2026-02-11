import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[][] coin = new int[k+1][2];
        int[][] dp = new int[k+1][t + 1]; //dp[k][t] =  k번째 동전까지 사용했을때 t원을 만들 수 있는 경우의 수
        //만약 k 번째 동전의 가치가 v 라면 dp[k][t+v] += dp[k-1][t] 가 된다
        dp[0][0] = 1;
        for (int i = 1; i <= k; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int quantity = Integer.parseInt(st.nextToken());

            coin[i][0] = index;
            coin[i][1] = quantity;
        }
        for (int i = 1; i <=k; i++){
            int coinPrice = coin[i][0];
            int coinCount = coin[i][1];
            for (int value = 0; value <=t; value++){
                for (int cnt = 0; cnt <= coinCount; cnt++){
                    int nextValue = value + cnt * coinPrice;
                    if (nextValue > t) break;
                    dp[i][nextValue] += dp[i - 1][value];
                }
            }
        }
        System.out.println(dp[k][t]);

    }


}

