import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        final int FAIL = 100000;
        int answer = FAIL;


        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<Me> q = new ArrayDeque<>();

        q.add(new Me(0, 0, 1));
        visited[0][0] = true;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};



        while(!q.isEmpty()){
            Me now = q.poll();
            if (now.x == n -1 && now.y == m - 1){
                answer = Math.min(now.count, answer);
            }

            else {
                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dr[i];
                    int ny = now.y + dc[i];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] != 0 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new Me(nx, ny, now.count + 1));
                    }
                }
            }

        }

        return (answer != FAIL ? answer : -1);
    }
    public class Me {
        int x;
        int y;
        int count;

        public Me(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
