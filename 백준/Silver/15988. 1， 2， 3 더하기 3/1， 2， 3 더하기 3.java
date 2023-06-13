import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.valueOf(br.readLine());
        long dp[] = new long[1000001];
        dp[1] = 1; dp[2] = 2; dp[3] = 4;

        for(int i = 4; i <1000001; i++){
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3])%1000000009;
        }


        for(int i = 0; i < t; i++){
            int n = Integer.valueOf(br.readLine());
            bw.write(dp[n] + "\n");

        }

        bw.flush();
        bw.close();

    }
}