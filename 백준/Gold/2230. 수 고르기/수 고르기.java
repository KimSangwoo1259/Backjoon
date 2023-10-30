import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++){
            arr[i] = Integer.valueOf(br.readLine());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = 1;
        int ans = 2000000000;
        int temp;
        while (right < n){
            temp = arr[right] - arr[left];
            if (temp >= m){
                ans = Math.min(ans,temp);
                if (right - left == 1){
                    right++;
                }
                left++;
            }
            else
                right++;
        }
        System.out.println(ans);

    }
}
