import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());

        Integer[] arr = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arr[i] = Integer.valueOf(st.nextToken());
        }
        Arrays.sort(arr, Comparator.reverseOrder());

        int start = 0;
        int end = arr[0];
        int mid = (start + end) / 2;
        long sum = 0;
        while (start <= end){

            for (int i = 0; i < n; i++){
                if (arr[i] - mid <= 0)
                    break;
                sum += (arr[i] - mid);
            }
            if (sum >= m)
                start = mid+1;
            else
                end = mid - 1;
            sum = 0;
            mid = (start + end)/2;


        }

        System.out.println(mid);
    }

}