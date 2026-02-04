import java.io.*;
import java.util.StringTokenizer;

public class Main {


    static int n;
    static int[][] paper;
    static int[] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        ans = new int[3];
        paper = new int[n][n];

        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursion(n,0,0);
        System.out.println(ans[0] + "\n" + ans[1] + "\n" + ans[2]);
    }
    static void recursion(int len, int x, int y){
        int firstValue = paper[x][y];

        if (len == 1){
            ans[firstValue + 1]++;
            return;
        }

        boolean isSame = true;
        for (int i = x; i < x +len; i++){
            for (int j = y; j < y + len; j++){
                if (firstValue != paper[i][j]){
                    isSame= false;
                    break;
                }
                if (!isSame)
                    break;

            }
        }
        if (isSame){
            ans[firstValue + 1]++;
            return;
        }
        for (int i = x; i < x + len; i += (len / 3)){
            for (int j = y; j < y + len; j += (len / 3)){
                recursion(len/3,i,j);
            }
        }

    }


}
