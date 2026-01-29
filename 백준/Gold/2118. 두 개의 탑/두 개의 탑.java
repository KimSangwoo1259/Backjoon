import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 배열 크기

        int ans = 0;
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int value = Integer.parseInt(br.readLine());
            arr[i] = value;
        }
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++){
            sum[i] = sum[i - 1] + arr[i];
        }
        int left = 1;
        int right = 1;
        int sumValue = sum[n];

        while (right < n && left <= right){
            int dist = sum[right] - sum[left - 1];
            int oppDist = sumValue - dist;

            int trueDist = Math.min(dist, oppDist);

            ans = Math.max(ans, trueDist);

            if (dist > oppDist){
                left++;
                if (left > right)
                    right++;
            }
            else if (dist < oppDist){
                right++;
            }
            else // 둘이 같아면 그게 최대 길이
                break;

        }
        System.out.println(ans);
    }
}
