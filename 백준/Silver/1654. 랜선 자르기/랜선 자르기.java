import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.valueOf(st.nextToken());
        int n = Integer.valueOf(st.nextToken());

        Integer[] arr = new Integer[k];

        for (int i = 0; i < k; i++){
            arr[i] = Integer.valueOf(br.readLine());
        }
        Arrays.sort(arr, Comparator.reverseOrder());

        long left = 1;
        long right = arr[0];
        long mid = (left + right) / 2;
        long ans = -1;
        long sum;
        long temp;
        while(left <= right){
            sum = 0;
            for (int i = 0; i < k; i++){
                temp = arr[i] / mid;
                if (temp == 0)
                    break;
                sum += temp;
            }
            if (sum >= n){
                ans = mid;
                left = mid + 1;
            }
            else
                right = mid - 1;
            mid = (left + right) / 2;

        }
        System.out.println(ans);

    }
}