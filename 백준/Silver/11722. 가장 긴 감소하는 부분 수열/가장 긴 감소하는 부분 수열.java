import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.valueOf(br.readLine());
        int arr[] = new int[n];
        int dp[] = new int[n]; //가장긴 감소수열을 저장한 수열

        dp[0] = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i <n; i++){ 
            arr[i] = Integer.valueOf(st.nextToken());
        }
        for (int i = 1; i< n; i++){
            dp[i] = 1;
            for (int j = 0; j < i; j++){
                if(arr[i]< arr[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxValue = Arrays.stream(dp).max().getAsInt(); //배열 내 최대값
        bw.write(String.valueOf(maxValue));
        bw.flush();
        bw.close();


    }
}
