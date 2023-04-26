import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int dp[] = new int[11];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        for(int i = 3; i < dp.length; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.valueOf(br.readLine());
        int index[] = new int[T];
        for (int i = 0; i < T; i++){
            index[i] = Integer.valueOf(br.readLine());
        }

        for (int i = 0; i < T; i++){
            bw.write(String.valueOf(dp[index[i]-1]) + '\n');
        }
        bw.flush();
        bw.close();
    }
}
