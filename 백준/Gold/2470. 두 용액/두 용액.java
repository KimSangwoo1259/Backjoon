import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        Integer[] arr = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++){
            arr[i] = Integer.valueOf(st.nextToken());
        }
        Arrays.sort(arr);
        int curVal = 2000000001;
        int curLeft = 0;
        int curRight = n-1;
        int left = 0;
        int right = n-1;
        int temp;
        while(left < right){
            temp = arr[left] + arr[right];

            if (Math.abs(curVal)> Math.abs(temp)){
                curVal = temp;
                curLeft = left;
                curRight = right;
            }

            if (temp == 0)
                break;

            if (temp < 0)
                left++;
            else
                right--;

        }
        System.out.println(arr[curLeft] + " " + arr[curRight]);
    }
}