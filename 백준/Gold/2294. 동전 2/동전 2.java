import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coin = new int[n];
        int[] dp = new int[100001];
        Arrays.fill(dp, 10001);
        for (int i = 0; i < n; i ++){
            int value = Integer.parseInt(br.readLine());
            coin[i] = value;
            dp[value] = 1;
        }
        for (int i = 1; i <= k; i++){
            if (dp[i] == 10001){
                for (int j = 1; j <= i/2; j++){
                    dp[i] = Math.min(dp[i], dp[i - j] + dp[j]);
                }
            }
        }
        if (dp[k] == 10001)
            dp[k] = -1;
        System.out.println(dp[k]);


    }


}

