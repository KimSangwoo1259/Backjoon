import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());
        int arr[] = new int[n];
        int dp[] = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arr[i] = Integer.valueOf(st.nextToken());
        }

        for (int i = 0; i < n; i++){
            dp[i] = 1;
            for (int j = 0; j <i; j++){
                if(arr[i] < arr[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int length = Arrays.stream(dp).max().getAsInt();
        
        System.out.println(n- length);
    }
}