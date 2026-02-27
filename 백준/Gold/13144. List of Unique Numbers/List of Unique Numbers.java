import java.io.*;
import java.util.*;


public class Main {


    // 1 2 3 4 5  3
    // 1 2 3 4 5 12 23 34 45 123 234 345 1234 2345 12345
    // 45678 // 45 45
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        long[] sum = new long[n + 1];
        for (int i = 1; i <= n; i++){
            sum[i] = sum[i - 1] + i;
        }
        long ans = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());


        for (int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left =1;
        int right = 1;
        int visited = 0;
        Set<Integer> set = new HashSet<>();

        while(right <= n){
            int value = arr[right];

            if (set.contains(value)){
                ans += (sum[right - left] - sum[visited -left +1]);
                while(set.contains(value)){
                    set.remove(arr[left]);
                    left++;
                }
                visited = right-1;
                set.add(value);
            }
            else {
                set.add(value);
            }
            right++;
        }

        ans += sum[n - left + 1] - sum[visited - left + 1];

        System.out.println(ans);
    }

}