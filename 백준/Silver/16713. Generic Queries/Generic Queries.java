import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());
        int q = Integer.valueOf(st.nextToken());


        int[] arr = new int[n + 1];
        int[] sum = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        int temp = Integer.valueOf(st.nextToken());
        arr[1] = temp;
        sum[1] = temp;

        for (int i = 2; i <= n; i++){
            temp = Integer.valueOf(st.nextToken());
            arr[i] = temp;
            sum[i] = sum[i - 1] ^ temp;
        }
        int ans = 0;
        for (int i = 0; i <q; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());

            ans ^= sum[b] ^ sum[a - 1];
        }
        System.out.println(ans);
    }
}