import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()); //인출할 횟수

        int[] arr = new int[n];
        int answer = 0;
        
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int left = Arrays.stream(arr).max().getAsInt();
        int right = 2000000000;

        while(left <= right){
            int mid = (left + right) / 2;

            int cur = 0;
            int count = 0;
            for (int i = 0; i < n; i++){
                if (cur < arr[i]){
                    cur = mid;
                    count++;
                }
                cur -= arr[i];
            }
            if (count <= m){
                right = mid - 1;
                answer = mid;
            }
            else {
                left = mid + 1;
            }

        }
        System.out.println(answer);
    }
}