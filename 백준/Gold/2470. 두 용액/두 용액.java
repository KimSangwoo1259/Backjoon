import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        int min = 2000000000;


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer[] arr = new Integer[n];

        for (int i = 0 ; i < n; i ++){
            int va = Integer.parseInt(st.nextToken());
            arr[i] = va;
        }
        Arrays.sort(arr);

        int answerLeft = 0;
        int answerRight = 100000;

        int left = 0;
        int right = n - 1;

        while(left < right){
            int temp = arr[left] + arr[right];

            if (Math.abs(temp) < min){
                answerLeft = left;
                answerRight = right;
                min = Math.abs(temp);
            }

            if (temp >= 0){
                right--;
            }
            else {
                left++;
            }
        }
        System.out.println(arr[answerLeft] + " " + arr[answerRight]);
    }
}
