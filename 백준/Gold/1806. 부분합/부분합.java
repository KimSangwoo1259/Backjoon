import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());
        int s = Integer.valueOf(st.nextToken());

        int[] arr = new int[n+1];
        int[] sumArr = new int[n+1];
        int ans = 0;
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++){
            arr[i] = Integer.valueOf(st.nextToken());
        }

        for (int i = 1; i <= n; i++){
            sumArr[i] = sumArr[i - 1] + arr[i];
        }
        if (sumArr[n]>= s){
            ans = n;
        }
        else {
            System.out.println(ans);
            return;
        }
        int left = 1;
        int right = 1;
        int temp;
        while (right <= n){
            temp = sumArr[right] - sumArr[left-1];
            if (temp >= s){
                ans = Math.min(ans, right - left + 1);
                if (left == right){
                    left++;
                    right++;
                }
                else {
                    left++;
                }

            }
            else {
                right++;
            }
        }
        System.out.println(ans);


    }
}