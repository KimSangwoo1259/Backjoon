import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());
        int[] arr = new int[n + 1];
        int ans = 0;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.valueOf(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }
        int totalDistance = sum[n];
        int temp = 0;
        int reverse = 0;
        int left = 0;
        int right = 1;

        while (right <= n) {
            temp = sum[right] - sum[left];
            reverse = totalDistance - temp;
            if (temp < reverse) {
                right++;
                ans = Math.max(ans, temp);
            } else if (temp > reverse) {
                left++;
                ans = Math.max(ans, reverse);
            } else {
                ans = temp;
                break;
            }
        }
        System.out.println(ans);

    }
}