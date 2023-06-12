import java.io.*;

public class Main {

    // 주어진수 n에서 가장 가까운, 즉 n보다 작은 수중에 제일큰 제곱수를구해서 그걸 뺀값의 dp값을 더해주면 나오지 않을까? ex) 11 = 9 + 2 이므로 1+dp[2]를 해주면 된다. -> 예외발생 ex) 32는 이코드로 하면 5가 나오는데
    // 16 + 16 으로 2가 나올 수 있음 따라서 n값보다 작은 제곱수들을 뺀 dp값을 모두 고려해야함
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.valueOf(br.readLine());

        int dp[] = new int[n+1]; // 자연수들의 제곱수로 나타낼수 있는 최소항의 개수를 나타낸 배열
        int curMaxSqaNum = 1; //현재 가장큰 제곱수의 제곱근

        for (int i = 1; i <= n; i++){
            dp[i] = i; //초기화
            for(int j = 1; j * j <= i; j++){
                if (dp[i] > dp[i - (j * j)] + 1) {
                    dp[i] = dp[i - (j * j)] + 1;
                }
            }
        }
        bw.write(String.valueOf(dp[n]));
        bw.flush();
        bw.close();

    }

}