import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int ans = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for (int j = n -1; j >= 0; j--){
            int target = arr[j];
            int left = 0;
            int right = n -1;
            if(j == 0){
                left++;
            }
            if(j == n- 1){
                right--;
            }
            while(left < right && right < n && left >= 0){
                int temp = arr[left] + arr[right];
                if (temp < target){
                    left++;
                    if (left == j)
                        left++;
                }
                else if(temp > target){
                    right--;
                    if (right == j)
                        right--;
                }
                else {
                    ans++;
                    break;
                }
            }
        }
        System.out.println(ans);
    }

}