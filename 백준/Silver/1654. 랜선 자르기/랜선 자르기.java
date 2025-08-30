import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long answer = 0;
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        Long[] arr = new Long[k];
        for (int i = 0; i < k; i++){
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr,Comparator.reverseOrder());
        long left = 1;
        long right = arr[0];
        while(left <= right){
            long mid = (left + right) / 2;
            int temp = 0;
            for (long v : arr){
                long add = v / mid;
                if (add == 0)
                    break;
                temp += add;
            }
            if (temp >= n){
                left = mid + 1;
                answer = mid;
            }
            else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
