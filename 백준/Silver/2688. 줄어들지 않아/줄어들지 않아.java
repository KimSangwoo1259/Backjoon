import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.valueOf(br.readLine());


        int size = 64;
        long dp[][] = new long[size+1][10];

        for (int i = 0; i < 10; i++){
            dp[1][i] = 1;
        }
        for (int i = 2; i<= size; i++){
            for (int j = 0; j < 10; j++){
                for (int k = j; k < 10; k++){
                    dp[i][j] += dp[i - 1][k];
                }
            }
        }
        for (int j = 0; j < t ; j ++) {
            long sum = 0;
            int n = Integer.valueOf(br.readLine());
            for (int i = 0; i < 10; i++) {
                sum += dp[n][i];
            }
            bw.write(sum + "\n");

        }
        bw.flush();
        bw.close();
    }
} //int 로 해서 2번틀림.. 범위 생각 잘하자