import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        int max = 0;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        int[][] canvas = new int[n][m];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                canvas[i][j] = Integer.valueOf(st.nextToken());
            }
        }
        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (canvas[i][j] == 1 && !visited[i][j]){
                    int temp = 0;
                    q.add(new Point(i, j));
                    visited[i][j] = true;
                    count++;
                    while (!q.isEmpty()){
                        Point now = q.poll();
                        temp++;
                        for (int k = 0; k < 4; k++){
                            int nx = now.x + dr[k];
                            int ny = now.y + dc[k];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < m){
                                if (canvas[nx][ny] == 1 && !visited[nx][ny]){
                                    q.add(new Point(nx, ny));
                                    visited[nx][ny] = true;
                                }
                            }
                        }
                    }
                    max = Math.max(temp, max);
                }
            }
        }
        System.out.println(count + "\n" + max);

    }
    static class Point{
        int x, y;
        Point(int _x, int _y){
            x = _x;
            y = _y;
        }
    }
}