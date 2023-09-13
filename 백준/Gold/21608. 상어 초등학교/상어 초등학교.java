import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        int n = Integer.valueOf(br.readLine());
        int[][] students = new int[n * n + 1][4]; // 학생번호에 해당하는 학생이 좋아하는 학생의 번호
        int[] sequence= new int[n * n + 1];
        int sit[][] = new int[n + 1][n + 1];

        for (int i = 1; i <= n * n; i++){
            st = new StringTokenizer(br.readLine());
            int stNum = Integer.valueOf(st.nextToken());
            sequence[i] = stNum;
            for (int j = 0; j < 4; j++){
                students[stNum][j] = Integer.valueOf(st.nextToken());
            }
        }
        sit[2][2] = sequence[1];

        for (int i = 2; i <= n * n; i++){
            int around = -1;
            int curX = 1;
            int curY = 1;
            int blank = 0;
            for (int j = 1; j <= n; j++){
                for (int l = 1; l <= n; l++){
                    int temp = 0;
                    int tempBlank = 0;
                    if(sit[j][l] != 0)
                        continue;
                    else{
                        if(sit[j][l-1] != 0){
                            for (int q = 0; q < 4; q++){
                                if(sit[j][l-1] == students[sequence[i]][q]){
                                    temp++;
                                    break;
                                }
                            }
                        }
                        else {
                            if(l != 1)
                                tempBlank++;
                        }
                        if (sit[j-1][l] != 0){
                            for (int q = 0; q < 4; q++){
                                if(sit[j-1][l] == students[sequence[i]][q]){
                                    temp++;
                                    break;
                                }
                            }

                        }else {
                            if(j != 1)
                                tempBlank++;
                        }
                        if(j !=n){
                            if(sit[j+1][l] != 0){
                                for (int q = 0; q < 4; q++){
                                    if(sit[j+1][l] == students[sequence[i]][q]){
                                        temp++;
                                        break;
                                    }
                                }

                            }
                            else {
                                tempBlank++;
                            }
                        }
                        if (l != n){
                            if(sit[j][l+1] != 0){
                                for (int q = 0; q < 4; q++){
                                    if(sit[j][l+1] == students[sequence[i]][q]){
                                        temp++;
                                        break;
                                    }
                                }

                            }else {
                                tempBlank++;
                            }
                        }
                        if(temp > around) {
                            around = temp;
                            blank = tempBlank;
                            curX = j;
                            curY = l;

                        }

                        else if(temp == around){
                            if(tempBlank > blank){
                                blank = tempBlank;
                                curX = j;
                                curY = l;

                            }
                        }
                    }

                }
            }
            if(curX == 1 && curY == 1){
                if(sit[1][1] != 0){
                    boolean isBreak = false;
                    for (int z = 1; z <=n; z++){
                        for (int x = 1; x <=n; x++){
                            if (sit[z][x] == 0){
                                sit[z][x] = sequence[i];
                                isBreak = true;
                                break;
                            }
                        }
                        if(isBreak)
                            break;
                    }
                }
            }
            sit[curX][curY] = sequence[i];
        }
        int sum = 0;
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++){
              int count = 0;
              if(i != 1){
                  for (int k = 0; k < 4; k++){
                      if(sit[i-1][j] == students[sit[i][j]][k]){
                          count++;
                          break;
                      }
                  }
              }
              if(i != n){
                  for (int k = 0; k < 4; k++){
                      if(sit[i+1][j] == students[sit[i][j]][k]){
                          count++;
                          break;
                      }
                  }
              }
              if(j != 1){
                  for (int k = 0; k < 4; k++){
                      if(sit[i][j-1] == students[sit[i][j]][k]){
                          count++;
                          break;
                      }
                  }
              }
              if(j != n){
                  for (int k = 0; k < 4; k++){
                      if(sit[i][j+1] == students[sit[i][j]][k]){
                          count++;
                          break;
                      }
                  }
              }
              if(count != 0)
                  sum += Math.pow(10, count - 1);
              }
            }
        System.out.println(sum);
    }

}