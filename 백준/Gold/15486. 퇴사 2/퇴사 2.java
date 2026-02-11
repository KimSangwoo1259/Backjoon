import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n + 1][2];

        for (int i= 1; i <=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n + 2];

        for (int i = 1; i <=n; i++){
            int nextDay = i + arr[i][0];
            dp[i] = Math.max(dp[i],dp[i-1]);
            if (nextDay<= n+1){
                dp[nextDay] = Math.max(dp[nextDay], arr[i][1] + dp[i]);
            }

        }

       System.out.println(Arrays.stream(dp).max().getAsInt());

    }

}

