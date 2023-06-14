import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.valueOf(br.readLine());

        int dp[] = new int[10];
        dp[2] = 2;
        for (int i = 3; i <=9; i ++){
            dp[i] = dp[i-1] * 3;
        }

        bw.write(String.valueOf(dp[n]));
        bw.flush();
        bw.close();
    }



}