import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 1000000000;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        Queue<Me> q = new LinkedList<>();
        q.add(new Me(0, 0, 0));
        while (!q.isEmpty()) {
            Me now = q.poll();
            if (now.x == maps.length - 1 && now.y == maps[0].length - 1) {
                answer = Math.min(answer, now.count);
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dr[i];
                int ny = now.y + dc[i];
                if (nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length) {
                    if(!visited[nx][ny] && maps[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        q.add(new Me(nx, ny, now.count + 1));
                    }
                }
            }
        }
        if (answer == 1000000000)
            return -1;
        
        return answer+1;
    }
    static class Me {
        int x,y,count;
        Me(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}