import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());
        int[] arr = new int[501];
        int[] dp = new int[501];
        int max = 0; // index중 최대값 -> 최대값 만큼 for문을 돌리기 위해
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int index = Integer.valueOf(st.nextToken());
            arr[index] = Integer.valueOf(st.nextToken());
            dp[index] = 1;
            max = Math.max(max, index);
        }
        for (int i = 1; i <= max; i++){
            for (int j = 1; j < i; j++){
                if(arr[i] > arr[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int maxValue = Arrays.stream(dp).max().getAsInt(); // 최대 증가 수열 값
        System.out.println(n - maxValue);

    }
}
//왼쪽을 index, 오른쪽을 value로 생각해서 LIS 알고리즘으로 풀면 답이 된다

// 8 2 9 1 4 6 7 10