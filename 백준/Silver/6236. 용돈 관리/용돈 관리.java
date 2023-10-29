import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());

        int[] arr = new int[n];
        int count = 1;

        int max = 0;
        for (int i = 0; i < n; i++){
            arr[i] = Integer.valueOf(br.readLine());
            max =  Math.max(arr[i], max);
        }
        int left = max;
        int right = 10000*1000000;
        int mid = (left + right) / 2;
        int ans = -1;

        while (left <= right){
            int amount = mid;
            count = 1;
            for (int i = 0; i < n; i++){
                if (amount < arr[i]){
                    amount = mid;
                    count++;
                }
                    amount -= arr[i];

            }
            if (count <= m){
                right = mid -1;
                ans = mid;
            }
            else
                left = mid + 1;
            mid = (left + right) / 2;

        }

        System.out.println(ans);


    }
}