import java.io.*;
import java.util.StringTokenizer;

public class Main { //TODO 다시 풀어보기

    static int[][] getPrefix(char[][] map) {
        int[][] arr = new int[map.length][map[0].length];
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[0].length; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1] + ((map[i][j] == '*') ? 1 : 0);
            }
        }
        return arr;
    }

    static int getAroundLife(int[][] tempSum, int n, int m, int k) {
        int rightX = Math.min(tempSum.length - 1, n + k);
        int rightY = Math.min(tempSum[0].length - 1, m + k);
        int leftX = Math.max(1, n - k);
        int leftY = Math.max(1, m - k);

        return tempSum[rightX][rightY] - tempSum[leftX - 1][rightY] - tempSum[rightX][leftY - 1] + tempSum[leftX - 1][leftY - 1];

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        int t = Integer.valueOf(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int k = Integer.valueOf(st.nextToken());
        int a = Integer.valueOf(st.nextToken());
        int b = Integer.valueOf(st.nextToken());

        char[][] arr = new char[n + 1][m + 1];

        String temp;
        for (int i = 1; i <= n; i++) {
            temp = br.readLine();
            for (int j = 1; j <= m; j++) {
                arr[i][j] = temp.charAt(j - 1);
            }
        }

        for (int time = 0; time < t; time++) {
            int[][] tempSum = getPrefix(arr);
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    int aroundLife = getAroundLife(tempSum, i, j, k);
                    if (arr[i][j] == '*') {
                        aroundLife--;
                        if (aroundLife < a || aroundLife > b)
                            arr[i][j] = '.';
                    } else {
                        if (aroundLife > a && aroundLife <= b) {
                            arr[i][j] = '*';
                        }
                    }
                }
            }


        }
        for (int i = 1; i <=n; i++){
            for (int j = 1; j <= m; j++){
                bw.write(arr[i][j]);
            }
            bw.write("\n");

        }

        bw.flush();
        bw.close();
    }
}