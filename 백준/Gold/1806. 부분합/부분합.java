import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int ans = 100000001;
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        long curSum = 0;
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0; int right = 0;
        curSum = arr[right];

        while (left < n && right < n && (left <= right)){
            if (curSum >= s){
                ans = Math.min(ans, right - left + 1);
                curSum -= arr[left];
                left++;
            }
            else {
                right++;
                if (right < n)
                    curSum += arr[right];
            }
        }
          if (ans == 100000001)
            ans = 0;
        System.out.println(ans);
    }
}
