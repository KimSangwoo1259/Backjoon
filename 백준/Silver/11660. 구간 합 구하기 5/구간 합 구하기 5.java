import java.io.*;
import java.util.StringTokenizer;

public class Main {


    // 일단 사각형 의 부분합을 구한다.
    // x1,y1 부터 x2,y2 까지의 부분합 점화식 sum[x2][y2] - sum[x1-1][y2] - sum[x2][y1-1] + sum[x1-1][y1-1]
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int [][] arr = new int[n+1][n+1];
        for (int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] sum = new int[n+1][n+1];

        sum[1][1] = arr[1][1];

        for (int i = 2; i <= n; i++){
            sum[i][1] = sum[i - 1][1] + arr[i][1];
            sum[1][i] = sum[1][i - 1] + arr[1][i];
        }

        for (int i = 2; i <= n; i++){
            for (int j = 2; j <= n; j++){
                sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + arr[i][j];
            }
        }
        for (int i = 0; i < m; i ++){
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int ans = sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];
            bw.write(ans + "\n");

        }
        bw.flush();
        bw.close();

    }
}