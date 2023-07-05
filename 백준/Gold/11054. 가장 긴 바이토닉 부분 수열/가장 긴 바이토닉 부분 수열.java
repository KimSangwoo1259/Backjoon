import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int[] dp = new int[n];
        int[] dpR = new int[n];
        for (int i= 0; i < n; i++){
            arr[i] = Integer.valueOf(st.nextToken());
            dp[i] = 1;
            dpR[i] = 1;
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < i; j++){
                if(arr[i] > arr[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            for (int k = n-1; k > n-1-i; k--){
                if(arr[n-1-i] > arr[k])
                    dpR[n-1-i] = Math.max(dpR[n-1-i], dpR[k] + 1);
            }
        }
        for (int i = 0; i < n; i++){
            dp[i] += (dpR[i] - 1);
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());

    }
}