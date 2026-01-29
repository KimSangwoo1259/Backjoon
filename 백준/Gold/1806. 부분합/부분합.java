import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 배열 크기
        int s = Integer.parseInt(st.nextToken()); // 연속된 숫자 합이 s이상 이어여함

        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }

        int ans = 100001;

        int left = 1;
        int right = 1;

        while (right <= n) {
            int temp = sum[right] - sum[left - 1];
            if (temp >= s) {
                int len = right - left + 1;
                ans = Math.min(ans, len);
                left++;
                if (len == 1)
                    right++;
            } else {
                right++;
            }

        }
        if (ans == 100001)
            ans = 0;
        System.out.println(ans);

    }
}