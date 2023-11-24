import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] ans;
    static int[][] arr;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.valueOf(br.readLine());
        ans = new int[3];
        arr = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                arr[i][j] = Integer.valueOf(st.nextToken());
            }
        }
        cut(0, 0, n);
        for (int i = 0; i < 3; i++){
            System.out.println(ans[i]);
        }


    }
    static void cut(int x, int y, int dif){
        if (dif == 1){
            ans[arr[x][y]+ 1]++;
            return;
        }
        int temp = arr[x][y];

        boolean isAllSame = true;

        for (int i = x; i < x + dif; i++){
            for (int j = y; j < y + dif; j++){
                if (temp != arr[i][j]){
                    isAllSame = false;
                    break;
                }
            }
            if (!isAllSame)
                break;
        }
        if (isAllSame){
                ans[temp+1]++;
            return;
        }
        else {
            int nextDif = dif / 3;
            cut(x,y,nextDif);
            cut(x,y+nextDif,nextDif);
            cut(x, y + nextDif * 2, nextDif);
            cut(x+nextDif,y,nextDif);
            cut(x+nextDif,y+nextDif,nextDif);
            cut(x+nextDif, y + nextDif * 2, nextDif);
            cut(x+nextDif*2,y,nextDif);
            cut(x+nextDif*2,y+nextDif,nextDif);
            cut(x+nextDif*2, y + nextDif * 2, nextDif);
        }
    }

}