import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coin = new int[n+1];
        int[] dp = new int[k+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i ++){
            int value = Integer.parseInt(br.readLine());
            coin[i] = value;
        }

      for (int i = 1; i <=n; i ++){
          for (int j = coin[i]; j <=k; j++){
              if (j - coin[i] >= 0){
                  dp[j] += dp[j - coin[i]];
              }
          }
      }
        System.out.println(dp[k]);


    }


}

