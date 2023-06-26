import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int box[] = new int[n + 1];
        int dp[] = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            box[i] = Integer.valueOf(st.nextToken());
        }
        for (int i = 1; i <= n; i++) {
            dp[i] = 1;
            for (int j = 1; j <i; j++){
                if(box[i] > box[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());

    }
}