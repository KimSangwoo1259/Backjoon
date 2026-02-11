import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n + 1][3];

        for (int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dpMax = new int[n + 1][3];
        int[][] dpMin = new int[n + 1][3];

        for (int i = 1; i <= n; i ++){
            dpMax[i][0] = board[i][0] + Math.max(dpMax[i - 1][0], dpMax[i - 1][1]);
            dpMax[i][1] = board[i][1] + Math.max(Math.max(dpMax[i - 1][0], dpMax[i - 1][1]), dpMax[i - 1][2]);
            dpMax[i][2] = board[i][2] + Math.max(dpMax[i - 1][1], dpMax[i - 1][2]);

            dpMin[i][0] = board[i][0] + Math.min(dpMin[i - 1][0], dpMin[i - 1][1]);
            dpMin[i][1] = board[i][1] + Math.min(Math.min(dpMin[i - 1][0], dpMin[i - 1][1]), dpMin[i - 1][2]);
            dpMin[i][2] = board[i][2] + Math.min(dpMin[i - 1][1], dpMin[i - 1][2]);
        }

        int max = Arrays.stream(dpMax[n]).max().getAsInt();
        int min = Arrays.stream(dpMin[n]).min().getAsInt();

        System.out.println(max + " "  + min);


    }

}
