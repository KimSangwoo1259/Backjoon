import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int answer = 0;
        int temp = 10000000;
        int row = maps.length;
        int col = maps[0].length();
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        boolean visited[][] = new boolean[row][col];

        Queue<Land> q = new LinkedList<>();

        int lx = 1000;
        int ly = 1000;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                char s = maps[i].charAt(j);
                if (s == 'S'){
                    q.add(new Land(i, j,0));
                    visited[i][j] = true;
                }
                else if (s =='L'){
                    lx = i;
                    ly = j;
                }
            }
        }
        while (!q.isEmpty()){
            Land now = q.poll();
            for (int i = 0; i < 4; i++){
                int nx = now.x + dr[i];
                int ny = now.y + dc[i];
                if (nx >= 0 && nx < row && ny >= 0 && ny < col){
                    if (!visited[nx][ny] && maps[nx].charAt(ny) != 'X'){
                        if (maps[nx].charAt(ny) == 'L'){
                            temp = Math.min(temp, now.time + 1);
                        }
                        else {
                            q.add(new Land(nx, ny, now.time + 1));
                            visited[nx][ny] = true;
                        }
                    }
                }
            }

        }
        if (temp == 10000000)
            return -1;

        answer += temp;
        temp = 10000000;
        visited = new boolean[row][col];
        visited[lx][ly] = true;
        q.add(new Land(lx, ly, 0));
        while (!q.isEmpty()){
            Land now = q.poll();
            for (int i = 0; i < 4; i++){
                int nx = now.x + dr[i];
                int ny = now.y + dc[i];
                if (nx >= 0 && nx < row && ny >= 0 && ny < col){
                    if (!visited[nx][ny] && maps[nx].charAt(ny) != 'X'){
                        if (maps[nx].charAt(ny) == 'E'){
                            temp = Math.min(temp, now.time + 1);
                        }
                        else {
                            q.add(new Land(nx, ny, now.time + 1));
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }
        if (temp == 10000000)
            return -1;

        answer += temp;
        return answer;
    }
    static class Land {
        int x, y,time;
        Land(int _x, int _y, int t){
            x = _x;
            y = _y;
            time = t;

        }
    }
}