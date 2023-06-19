import java.io.*;

public class Main {//
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



        long dp[][] = new long[101][10];
        long mod = 1000000000;
        for(int i = 1; i < 10; i++){
            dp[1][i] = 1;
        }

        for(int i = 2; i <= 100; i++){
            for(int j = 0; j <10; j++){
                if(j == 0)
                    dp[i][j] = dp[i - 1][1] % mod;
                else if(j == 9)
                    dp[i][j] = dp[i - 1][8] % mod;
                else
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;


            }
        }

        int n = Integer.valueOf(br.readLine());
        long answer = 0;

        for(int i = 0; i < 10; i++){
            answer = answer + dp[n][i];
        }


        bw.write(String.valueOf(answer % mod));
        bw.flush();
        bw.close();


    }
}
// 1 -> 9 // 2 -> 1 + 16 = 17 // 3-> 101, 121,123, // 212,210 232,234// ~~ // 987, 989

// 1      2       3 ~ 8 9
// 0,2 //1,3 //
// 2~8 로 시작하는 수들은 2배씩 늘어가 아니라
//  1           2                  3           ~~              8             9
// 01 21 23 // 12 10 32 34 // 23 21 43 45              // 76 78 98 // 87 89
// 01 10 12 (21 23 32 34 43 45 54 56 65 67 76 78) 87 89) x 2 98

// 1                2       3       ~       8       9
//010,012 212,210,232,234

// 즉 앞자리가 2 ~ 8 인수들은 2번 중복 쓰이고 1,9 는 기존대로 한번만 쓰임, + 0으로 작하는 애가 1개 추가