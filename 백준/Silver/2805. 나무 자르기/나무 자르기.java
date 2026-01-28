import java.io.*;
import java.util.StringTokenizer;

public class Main {

    //
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //나무 수
        int m = Integer.parseInt(st.nextToken()); // 가져가려는 나무 수
        int ans = -1;

        st = new StringTokenizer(br.readLine());
        int[] woodArr = new int[n];
        for (int i = 0; i < n; i++){
            woodArr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 1_000_000_000;

        while(left <= right){
            int mid = (left + right )/ 2;
            long sum = 0;
            for (int i = 0; i < n; i++){
                sum += Math.max(0, woodArr[i] - mid);
            }
            if (sum >= m) {
                left = mid + 1;
                ans = mid;
            }
            else
                right = mid - 1;
        }
        System.out.println(ans);
    }

}