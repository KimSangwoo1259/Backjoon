import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int answer = 0;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        final int X_LEN = land.length;
        final int Y_LEN = land[0].length;

        int[] oilAmount = new int[Y_LEN];

        boolean[][] visited = new boolean[X_LEN][Y_LEN];

        Queue<Oil> q = new LinkedList<>();

        for (int i = 0; i < X_LEN; i++){
            for (int j = 0; j < Y_LEN; j++){
                int yLeft = Y_LEN - 1;
                int yRight = 0;
                int amount = 0;
                if (land[i][j] == 1 && !visited[i][j]){
                    q.add(new Oil(i, j));
                    visited[i][j] = true;
                    while (!q.isEmpty()){
                        Oil now = q.poll();
                        amount++;
                        if (yLeft > now.y)
                            yLeft = now.y;
                        if (yRight < now.y)
                            yRight = now.y;
                        for (int k = 0; k < 4; k++){
                            int nx = now.x + dr[k];
                            int ny = now.y + dc[k];
                            if (nx >= 0 && nx < X_LEN && ny >= 0 && ny < Y_LEN){
                                if (!visited[nx][ny] && land[nx][ny] == 1){
                                    visited[nx][ny] = true;
                                    q.add(new Oil(nx, ny));
                                }
                            }
                        }
                    }
                }
                for (int k = yLeft; k <= yRight; k++){
                    oilAmount[k] += amount;
                }
            }
        }
        answer = Arrays.stream(oilAmount).max().getAsInt();
        return answer;
    }
    static class Oil {
        int x,y;
        Oil(int _x, int _y){
            x = _x;
            y = _y;
        }

    }
}