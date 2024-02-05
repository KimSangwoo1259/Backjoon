import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] answer = new int[2];
        int n = Integer.valueOf(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arr[i] = Integer.valueOf(st.nextToken());
        }
        int left = 0;
        int right = n - 1;
        answer[0] = arr[left];
        answer[1] = arr[right];
        int ans = answer[0] + answer[1];

        while (left < right){
            int temp = arr[left] + arr[right];
            if (Math.abs(ans) > Math.abs(temp)){
                ans = temp;
                answer[0] = arr[left];
                answer[1] = arr[right];
            }
            if (temp > 0)
                right--;
            else
                left++;
        }
        System.out.println(answer[0] + " " + answer[1]);

    }
}