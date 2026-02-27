import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];

        }
        Arrays.sort(arr);
        int ans = 0;
        int m = Integer.parseInt(br.readLine());

        if (sum <= m){
            System.out.println(arr[n-1]);
        }
        else {
            int left = 0;
            int right = arr[n - 1];
            while(left <= right){
                sum = 0;
                int mid = (left + right) / 2;
                for (int i = 0; i <n; i++){
                    sum += Math.min(mid, arr[i]);
                }
                if (sum <= m){
                    ans = mid;
                    left = mid + 1;
                }
                else {
                    right = mid - 1;

                }
            }
            System.out.println(ans);
        }




    }

}
