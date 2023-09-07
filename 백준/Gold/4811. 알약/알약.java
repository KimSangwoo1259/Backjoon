import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long dp[] = new long [31];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= 30; i++){
            long sum = 0;
            for (int j = 0; j < i; j++){
                sum += dp[j] * dp[i - j - 1];
            }
            dp[i] = sum;
        }
        while (true){
            int n = Integer.valueOf(br.readLine());
            if(n == 0)
                break;
            bw.write(dp[n] + "\n");


        }
        bw.flush();
        bw.close();
    }
}