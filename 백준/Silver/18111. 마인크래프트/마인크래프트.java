import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        int b = Integer.valueOf(st.nextToken());

        int[][] block = new int[n][m];

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                block[i][j] = Integer.valueOf(st.nextToken());
            }
        }
        int time = 1000000000;
        int blockAns = -1;
        for (int i = 0; i <= 256; i++){
            int tempBlock = b; // 블럭수
            int temp = 0;

            for (int j = 0; j < n; j++){
                for (int l = 0; l < m; l++){
                    if(block[j][l] - i >= 0){
                        temp += (block[j][l] - i) * 2;
                        tempBlock += (block[j][l] - i);

                    }
                    else {
                        temp += Math.abs(block[j][l] - i);
                        tempBlock -= Math.abs(block[j][l] - i);
                    }
                }
            }
            if(tempBlock >= 0){
                if(time >= temp){
                   if(time > temp){
                       time = temp;
                       blockAns = i;
                   }
                   else
                       blockAns = Math.max(blockAns, i);
                }

            }

        }
        System.out.println(time + " " + blockAns);



    }
}