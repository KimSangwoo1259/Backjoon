import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken()); // 지도 세로
        int m = Integer.valueOf(st.nextToken()); // 지도 가로
        int x = Integer.valueOf(st.nextToken()); // 주사위 x좌표
        int y = Integer.valueOf(st.nextToken()); // 주사위 y좌표
        int k = Integer.valueOf(st.nextToken()); // 명령 개수

        int map[][] = new int[n][m];

        int dice[] = new int[7]; // 윗면, 북 동 서 남 밑면 순서
        int diceTemp[];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                map[i][j] = Integer.valueOf(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++){
            int command = Integer.valueOf(st.nextToken());

            if(command == 1){ // 동쪽
                if (y == m - 1)
                    continue;
                else {
                    y++;
                    diceTemp = Arrays.copyOf(dice, 7);

                    diceTemp[3] = dice[1];
                    diceTemp[1] = dice[4];
                    diceTemp[4] = dice[6];
                    diceTemp[6] = dice[3];

                    dice = Arrays.copyOf(diceTemp, 7);
                    if (map[x][y] == 0)
                        map[x][y] = dice[6];
                    else {
                        dice[6] = map[x][y];
                        map[x][y] = 0;
                    }
                    bw.write(dice[1] + "\n");


                }
            }
            else if (command == 2){ // 서쪽
                if (y == 0)
                    continue;
                else {
                    y--;
                    diceTemp = Arrays.copyOf(dice, 7);

                    diceTemp[1] = dice[3];
                    diceTemp[4] = dice[1];
                    diceTemp[6] = dice[4];
                    diceTemp[3] = dice[6];

                    dice = Arrays.copyOf(diceTemp, 7);
                    if (map[x][y] == 0)
                        map[x][y] = dice[6];
                    else {
                        dice[6] = map[x][y];
                        map[x][y] = 0;
                    }
                    bw.write(dice[1] + "\n");
                }

            }
            else if (command == 3){ // 북쪽
                if (x == 0)
                    continue;
                else {
                    x--;
                    diceTemp = Arrays.copyOf(dice, 7);
                    diceTemp[2] = dice[1];
                    diceTemp[1] = dice[5];
                    diceTemp[5] = dice[6];
                    diceTemp[6] = dice[2];

                    dice = Arrays.copyOf(diceTemp, 7);
                    if (map[x][y] == 0)
                        map[x][y] = dice[6];
                    else {
                        dice[6] = map[x][y];
                        map[x][y] = 0;
                    }

                    bw.write(dice[1] + "\n");

                }
            }
            else{ // 남쪽
                if (x == n - 1)
                    continue;
                else {
                    x++;
                    diceTemp = Arrays.copyOf(dice, 7);
                    diceTemp[1] = dice[2];
                    diceTemp[5] = dice[1];
                    diceTemp[6] = dice[5];
                    diceTemp[2] = dice[6];

                    dice = Arrays.copyOf(diceTemp, 7);
                    if (map[x][y] == 0)
                        map[x][y] = dice[6];
                    else {
                        dice[6] = map[x][y];
                        map[x][y] = 0;
                    }

                    bw.write(dice[1] + "\n");

                }
            }
        }
        bw.flush();
        bw.close();

    }

}