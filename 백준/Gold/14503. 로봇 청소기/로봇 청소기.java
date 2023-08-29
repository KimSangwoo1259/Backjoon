import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int curX = Integer.valueOf(st.nextToken()); // 현재 x좌표
        int curY = Integer.valueOf(st.nextToken()); // 현재 y좌표
        int curD = Integer.valueOf(st.nextToken()); // 현재 로봇청소기가 보는 방향 (0-> 북쪽,1-> 동쪽,2-> 남쪽,3-> 서쪽)

        int ans = 0; //로봇 청소기가 청소하는 칸
        int room[][] = new int[n][m];

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                room[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        while (true){
            if(room[curX][curY] == 0){
                room[curX][curY] = -1;
                ans++;
            }
            boolean isAroundUncleaned = false;
            if(curX != 0){
                if(room[curX-1][curY] == 0)
                    isAroundUncleaned = true;
            }
            if (curX != n -1){

                if(room[curX+1][curY] == 0)
                    isAroundUncleaned = true;
            }
            if(curY != 0){
                if(room[curX][curY-1] == 0)
                    isAroundUncleaned = true;
            }
            if (curY != m -1){
                if(room[curX][curY+1] == 0)
                    isAroundUncleaned = true;
            }
            if(isAroundUncleaned){
                curD --;
                if (curD == -1)
                    curD = 3;
                switch (curD){
                    case 0: //북쪽
                        if(curX != 0){
                            if(room[curX-1][curY] == 0)
                                curX--;
                        }
                        break;
                    case 1: //동쪽
                        if(curY != m-1){
                            if(room[curX][curY+1] == 0)
                                curY++;
                        }
                        break;
                    case 2: //남쪽
                        if(curX != n-1){
                            if(room[curX+1][curY] == 0)
                                curX++;
                        }
                        break;
                    default:  //서쪽
                        if(curY != 0){
                            if(room[curX][curY-1] == 0)
                                curY--;
                        }
                        break;


                }

            }
            else {
                if(curD == 0){ // 북쪽
                    if(curX == n-1)
                        break;
                    else{
                        if(room[curX+1][curY] == 1)
                            break;
                        else
                            curX++;
                    }
                }
                else if(curD == 1){ // 동쪽
                    if(curY == 0)
                        break;
                    else{
                        if(room[curX][curY-1] == 1)
                            break;
                        else
                            curY--;
                    }

                }
                else if(curD == 2){ // 남쪽
                    if(curX == 0)
                        break;
                    else{
                        if(room[curX-1][curY] == 1)
                            break;
                        else
                            curX--;
                    }

                }
                else { // 서쪽
                    if(curY == m-1)
                        break;
                    else{
                        if(room[curX][curY+1] == 1)
                            break;
                        else
                            curY++;
                    }

                }
            }


        }
        System.out.println(ans);

    }
}