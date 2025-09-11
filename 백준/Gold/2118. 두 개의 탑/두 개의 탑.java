import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        int[] arr = new int[n];
        int[] sum = new int[n];

        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        sum[0] = arr[0];

        for (int i = 1; i < n; i++){
            sum[i] = arr[i] + sum[i - 1];
        }

        int left = 0;
        int right = 0;
        int totalSum = sum[n - 1];
        while(right < n){
            int minus;
            if (left == 0){
                minus = 0;
            }
            else {
                minus = sum[left - 1];
            }
            int straight = sum[right] - minus;
            int reverse = totalSum - straight;
            if (straight < reverse){
                right++;
                answer = Math.max(straight, answer);
            }
            else if (reverse < straight){
                left++;
                answer = Math.max(answer, reverse);
            }
            else {
                answer = reverse;
                break;
            }
        }


        System.out.println(answer);

    }
}
