import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        int[] dx = {-1, 1};
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        while (true){
            st = new StringTokenizer(br.readLine());
            int l = Integer.valueOf(st.nextToken());
            int r = Integer.valueOf(st.nextToken());
            int c = Integer.valueOf(st.nextToken());
            if (l == 0 && r == 0 && c == 0) {
                break;
            }
            int ans = 1000000000;
            boolean[][][] visited = new boolean[l][r][c];
            Queue<Point> q = new LinkedList<>();
            char[][][] building = new char[l][r][c];
            for (int i = 0; i < l; i++){
                for (int j = 0; j < r; j++){
                    String str = br.readLine();
                    for (int k = 0; k < c; k++){
                        char temp = str.charAt(k);
                        building[i][j][k] = temp;
                        if (temp == 'S'){
                            q.add(new Point(i, j, k, 0));
                            visited[i][j][k] = true;
                        }
                    }
                }
                String a = br.readLine();
            }
            while (!q.isEmpty()){
                Point now = q.poll();
                for (int i = 0; i < 4; i++){
                    int ny = now.y + dr[i];
                    int nz = now.z + dc[i];
                    if (ny >= 0 && ny < r && nz >= 0 && nz < c) {
                        if (building[now.x][ny][nz] == 'E') {
                            ans = Math.min(ans, now.time + 1);
                            continue;
                        }

                        if (!visited[now.x][ny][nz] && building[now.x][ny][nz] == '.') {
                            q.add(new Point(now.x, ny, nz, now.time + 1));
                            visited[now.x][ny][nz] = true;
                        }

                    }
                }
                for (int i = 0; i < 2; i++){
                    int nx = now.x + dx[i];
                    if (nx >= 0 && nx < l){
                        if (building[nx][now.y][now.z] == 'E'){
                            ans = Math.min(ans, now.time + 1);
                            continue;
                        }
                        if (!visited[nx][now.y][now.z] && building[nx][now.y][now.z] == '.'){
                            q.add(new Point(nx, now.y, now.z, now.time + 1));
                            visited[nx][now.y][now.z] = true;
                        }
                    }
                }

            }
            if (ans == 1000000000)
                sb.append("Trapped!" +"\n");
            else
                sb.append("Escaped in " + ans + " minute(s)." + "\n");
        }
        System.out.println(sb);
    }
    static class Point{
        int x,y, z,time;
        Point(int _x, int _y, int _z, int t){
            x = _x;
            y = _y;
            z = _z;
            time = t;
        }
    }
}