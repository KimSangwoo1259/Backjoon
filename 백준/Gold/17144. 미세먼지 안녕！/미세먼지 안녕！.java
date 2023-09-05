import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.valueOf(st.nextToken());
        int c = Integer.valueOf(st.nextToken());
        int t = Integer.valueOf(st.nextToken());

        int[][] sector = new int[r][c];
        int cleanerPos = 0; // 공기 청청기 위치
        int[][] sectorTemp;
        int[][] sectorTemp2;
        int stack = 0;

        for (int i = 0; i < r; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++){
                sector[i][j] = Integer.valueOf(st.nextToken());
                if(sector[i][j] == -1)
                    cleanerPos = i;
            }
        }

        for (int l = 0; l < t; l++){
            sectorTemp = Arrays.stream(sector).map(int[]::clone).toArray(int[][]::new); // 2차원 배열 복사
            for (int i = 0; i < r; i++){
                for (int j = 0; j < c; j++){
                    if(sector[i][j] >= 5){
                        if(i != 0 && sector[i-1][j] != -1){
                            sectorTemp[i - 1][j] += sector[i][j] / 5;
                            stack++;
                        }
                        if(i != r-1 && sector[i+1][j] != -1){
                            sectorTemp[i + 1][j] += sector[i][j] / 5;
                            stack++;
                        }
                        if (j != 0 && sector[i][j - 1] != -1) {
                            sectorTemp[i][j - 1] += sector[i][j] / 5;
                            stack++;
                        }
                        if(j != c -1 && sector[i][j + 1] != -1){
                            sectorTemp[i][j + 1] += sector[i][j] / 5;
                            stack++;
                        }
                        sectorTemp[i][j] -= (sector[i][j] / 5) * stack;
                        stack = 0;
                    }
                }
            }

            sectorTemp2 = Arrays.stream(sectorTemp).map(int[]::clone).toArray(int[][]::new); // 2차원 배열 복사
            sectorTemp2[cleanerPos-1][1] = 0;
            for (int i = 2; i < c; i++)
                sectorTemp2[cleanerPos - 1][i] = sectorTemp[cleanerPos - 1][i - 1];
            for (int i = cleanerPos -2; i >= 0; i--)
                sectorTemp2[i][c - 1] = sectorTemp[i + 1][c - 1];
            for (int i = c-2; i >=0; i--)
                sectorTemp2[0][i] = sectorTemp[0][i + 1];
            for (int i = 1; i < cleanerPos -1; i++)
                sectorTemp2[i][0] = sectorTemp[i-1][0];

            sectorTemp2[cleanerPos][1] = 0;
            for (int i = 2; i < c; i++)
                sectorTemp2[cleanerPos][i] = sectorTemp[cleanerPos][i - 1];
            for (int i = cleanerPos+1; i < r; i++)
                sectorTemp2[i][c-1] = sectorTemp[i-1][c-1];
            for (int i = c-2; i >=0; i--)
                sectorTemp2[r-1][i] = sectorTemp[r-1][i + 1];
            for (int i = r -2; i > cleanerPos; i--)
                sectorTemp2[i][0] = sectorTemp[i + 1][0];
            for (int i = 0; i < r; i++){
                for (int j = 0; j < c; j++){
                    sector[i][j] = sectorTemp2[i][j];
                }
            }
        }
        
        int sum = 2; // 공기 청청기 2개 의 -1 이 더해질 거라 미리 +2
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                sum += sector[i][j];
            }
        }
        System.out.println(sum);

    }
}