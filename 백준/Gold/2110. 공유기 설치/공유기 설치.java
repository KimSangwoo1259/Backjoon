import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken()); //설치할 공유기 수

        Integer[] arr = new Integer[n];
        int answer = 0;
        
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int left = 1;
        int right = arr[n - 1] - arr[0];

        while(left <= right){
            int mid = (left + right) / 2;
            int count = 0;
            count++;
            int curPos = 0;
            for (int i = 1; i < n; i++){
                int distance = arr[i] - arr[curPos];
                if (distance >= mid){
                    curPos = i;
                    count++;
                }
            }
            if (count >= c){
                answer = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
