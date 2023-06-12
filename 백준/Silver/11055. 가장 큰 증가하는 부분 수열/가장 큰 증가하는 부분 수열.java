import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.valueOf(br.readLine());
        int arr[] = new int[n]; //원래 배열
        int dp[] = new int[n]; // 증가수열의 합을 담아둔 dp
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }
        dp[0] = arr[0];

        for(int i = 1; i < n; i++){
            dp[i] = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
        }
        Arrays.sort(dp);//최대값이 맨 뒤로 가게됨

        bw.write(String.valueOf(dp[n-1]));
        bw.flush();
        bw.close();


    }
}