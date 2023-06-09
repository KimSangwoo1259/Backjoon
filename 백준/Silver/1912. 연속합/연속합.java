import java.io.*;

//만약 앞에 까지의 연속합이 1이 넘으면 원래거랑 더해주기, 아니면 그냥 자기자신부터 시작 // dp[i] = if(dp[i-1]>0) -> dp[i] = dp[i-1] + arr[i] else -> dp[i] = arr[i]
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



        int n = Integer.valueOf(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        String[] num = br.readLine().split(" ");
        for (int i = 0; i < n; i++){
            arr[i] = Integer.valueOf(num[i]);
        }

        dp[0] = arr[0];
        int max = dp[0]; // 연속합 최대값
        for(int i = 1; i < n; i++){
            dp[i] = (dp[i - 1] > 0) ? dp[i - 1] + arr[i] : arr[i];
            max = Math.max(max, dp[i]);
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();





    }
}