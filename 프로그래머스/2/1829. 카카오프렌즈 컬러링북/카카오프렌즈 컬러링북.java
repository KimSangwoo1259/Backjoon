import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                int curMax = 0;
                if (!visited[i][j] && picture[i][j] != 0){
                    numberOfArea++;
                    Queue<Pic> q = new LinkedList<>();
                    q.add(new Pic(i, j, picture[i][j]));
                    visited[i][j] = true;
                    while (!q.isEmpty()){
                        Pic now = q.poll();
                        curMax++;
                        for (int k = 0; k < 4; k++){
                            int nx = now.x + dr[k];
                            int ny = now.y + dc[k];
                            if (nx >= 0 && nx < m && ny >= 0 && ny < n){
                                if (!visited[nx][ny] && now.color == picture[nx][ny]){
                                    visited[nx][ny] = true;
                                    q.add(new Pic(nx, ny, now.color));
                                }
                            }
                        }
                    }
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, curMax);
                }
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    static class Pic{
        int x, y,color;
        Pic(int _x, int _y, int c){
            x = _x;
            y = _y;
            color = c;
        }
    }
}