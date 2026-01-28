import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    //
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 용돈 사둉 일
        int m = Integer.parseInt(st.nextToken()); // 인출 횟수
        int ans = -1;

        int[] money = new int[n];
        for (int i = 0; i < n; i++) {
            money[i] = Integer.parseInt(br.readLine());
        }

        int left = Arrays.stream(money).max().getAsInt();
        int right = 1_000_000_000;

        while (left <= right) {
            int withdrawCount = 0;
            int mid = (left + right) / 2;
            int currentMoney = 0;
            for (int i = 0; i < n; i++) {
                if (currentMoney < money[i]) {
                    currentMoney = mid;
                    withdrawCount++;
                } 
                currentMoney -= money[i];
                

            }
            if (withdrawCount <= m) { //인출을 원하는 횟수보다 적거나 같게 했다 -> 원하는거
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        System.out.println(ans);
    }


}