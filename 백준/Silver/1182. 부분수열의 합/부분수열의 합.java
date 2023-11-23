import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int s;
    static int ans;
    static int[] arr;
    static int[] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.valueOf(st.nextToken());
        s = Integer.valueOf(st.nextToken());
        ans = 0;
        arr = new int[n];
        temp = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arr[i] = Integer.valueOf(st.nextToken());
        }
        back(0,0);
        ans = (s == 0) ? ans - 1 : ans;
        System.out.println(ans);

    }
    static void back(int num, int sum){
        if (num == n){
            if (sum == s)
                ans++;

            return;
        }
        back(num + 1, sum + arr[num]);
        back(num +1 , sum);

    }
}