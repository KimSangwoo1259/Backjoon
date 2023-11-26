import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] maze;
    static int[][] count;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());

        maze = new int[n+1][m+1];
        count = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++){
            String str = br.readLine();
            for (int j = 1; j <=m; j++){
                maze[i][j] = str.charAt(j - 1) - '0';
            }
        }
        count[1][1] = 1;

        Queue<Point> q = new LinkedList<>();

        q.add(new Point(1, 1));

        while (!q.isEmpty()){
            Point now = q.poll();
            for (int i = 0; i < 4; i++){
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                if (nc <= 0 || nc > m || nr <= 0 || nr > n)
                    continue;
                if (maze[nr][nc] == 1 && count[nr][nc] == 0) {
                    q.add(new Point(nr, nc));
                    count[nr][nc] = count[now.r][now.c] + 1;
                }
            }

        }
        System.out.println(count[n][m]);


    }
    static class Point{
        int r,c;

        Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}