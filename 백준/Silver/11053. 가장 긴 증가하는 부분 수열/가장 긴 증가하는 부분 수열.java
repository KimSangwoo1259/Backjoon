import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n + 1];
        for (int i = 1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <=n; i++){
            int max = 0;
            for (int j = i-1; j >= 1; j--){
                if (arr[i] > arr[j]){
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }

}

