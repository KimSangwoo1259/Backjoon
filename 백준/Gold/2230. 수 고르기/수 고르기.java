import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        if (m == 0) {
            System.out.println(0);
            return;
        }
        int ans = 2000000001;

        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = 1;


        while (left < n && right < n && (left <= right)) {
            int dif = arr[right] - arr[left];

            if (dif >= m) {
                ans = Math.min(ans, dif);
                left++;
                if (left == right)
                    right++;

            } else {
                right++;
            }
        }
        System.out.println(ans);
    }
}
