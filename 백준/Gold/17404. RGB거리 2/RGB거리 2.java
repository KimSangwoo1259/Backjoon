import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int bigNum = 1000 * 1000;

        int n = Integer.valueOf(st.nextToken());
        int rgb[][] = new int[n+1][3];
        int dp1[][] = new int[n+1][3]; // 첫집이 R
        int dp2[][] = new int[n+1][3]; // 첫집이 G
        int dp3[][] = new int[n+1][3]; // 첫집이 B

        for (int i = 1; i <=n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <3; j++){
                rgb[i][j] = Integer.valueOf(st.nextToken());
            }
        }
        for (int i = 0; i <=2; i++){
            dp1[1][i] = dp2[1][i] = dp3[1][i] = rgb[1][i];
        }
        dp1[1][1] = dp1[1][2] = dp2[1][0] = dp2[1][2] = dp3[1][0] = dp3[1][1] = bigNum; // 정해놓지 않은 색깔 이외는 전부 큰수로 바꾸어 사실상 쓰지 않는 것으로 처리
        for (int i = 2; i <=n; i++){
            dp1[i][0] = Math.min(dp1[i - 1][1], dp1[i - 1][2]) + rgb[i][0];
            dp2[i][0] = Math.min(dp2[i - 1][1], dp2[i - 1][2]) + rgb[i][0];
            dp3[i][0] = Math.min(dp3[i - 1][1], dp3[i - 1][2]) + rgb[i][0];

            dp1[i][1] = Math.min(dp1[i - 1][0], dp1[i - 1][2]) + rgb[i][1];
            dp2[i][1] = Math.min(dp2[i - 1][0], dp2[i - 1][2]) + rgb[i][1];
            dp3[i][1] = Math.min(dp3[i - 1][0], dp3[i - 1][2]) + rgb[i][1];


            dp1[i][2] = Math.min(dp1[i - 1][1], dp1[i - 1][0]) + rgb[i][2];
            dp2[i][2] = Math.min(dp2[i - 1][1], dp2[i - 1][0]) + rgb[i][2];
            dp3[i][2] = Math.min(dp3[i - 1][1], dp3[i - 1][0]) + rgb[i][2];
        }

        int minArr[] = new int[]{dp1[n][1], dp1[n][2], dp2[n][0], dp2[n][2], dp3[n][0], dp3[n][1]};
        int min = Arrays.stream(minArr).min().getAsInt();

        System.out.println(min);



    }
}