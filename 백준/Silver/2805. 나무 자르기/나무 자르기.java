import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = -1;
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = 1000000000;

        while(left <= right){
            long sum = 0;
            int mid = (left + right) / 2;
            for (int i = 0; i < n; i++){
                sum += Math.max(0, arr[i] - mid);
            }
            if (sum >= m){
                answer = mid;
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        System.out.println(answer);

    }
}