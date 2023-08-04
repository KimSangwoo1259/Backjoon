import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.valueOf(st.nextToken());
        int w = Integer.valueOf(st.nextToken());

        int arr[] = new int[t+1];
        int dp[][] = new int[t+1][w+1];
        for (int i = 1; i <= t; i++) {
            arr[i] = Integer.valueOf(br.readLine());
        }


        for (int i = 0; i <= w; i++){
            for (int j = 1; j <= t; j++){
                if(arr[j] % 2 == 1){ // 1 인 경우
                    if(i % 2 == 0){ // 자두가 1의 위치에 있는 경우
                            dp[j][i] = dp[j - 1][i] + 1;
                    }
                    else{
                        if(i == 0)
                            dp[j][i] = dp[j - 1][i];
                        else{
                            dp[j][i] = Math.max(dp[j - 1][i], dp[j][i - 1]);
                        }
                    }
                }
                else{
                    if(i % 2 == 1){ // 자두가 2의 위치에 있는 경우
                        dp[j][i] = dp[j - 1][i] + 1;
                    }
                    else{
                        if(i == 0)
                            dp[j][i] = dp[j - 1][i];
                        else{
                            dp[j][i] = Math.max(dp[j - 1][i], dp[j][i - 1]);
                        }
                    }


                }




            }
        }
        int max = Arrays.stream(dp[t]).max().getAsInt();
        System.out.println(max);
        
    }
}