import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int n;
    static Point[][] pic;
    static boolean[][] visited;
    static int[] dc = {-1, 0, 1, 0};
    static int[] dr = {0, 1, 0, -1};
    static int ans1 = 0; // 적록색약 아닌경우
    static int ans2 = 0; // 적록색약인 경우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.valueOf(br.readLine());
        pic = new Point[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++){
            String temp = br.readLine();
            for (int j = 0; j < n; j++){
                pic[i][j] = new Point(i, j, temp.charAt(j));
            }
        }
        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < n; i++){ //적록색약 아닌경우
            for (int j = 0; j < n; j++){
                if (!visited[i][j]){
                    visited[i][j] = true;
                    q.add(pic[i][j]);
                    while(!q.isEmpty()){
                        Point temp = q.poll();
                        for (int k = 0; k < 4; k++){
                            int nc = temp.x + dc[k];
                            int nr = temp.y + dr[k];
                            if (nr < 0 || nr >= n || nc < 0 || nc >= n)
                                continue;
                            if (!visited[nc][nr] && temp.color == pic[nc][nr].color){
                                visited[nc][nr] = true;
                                q.add(pic[nc][nr]);
                            }

                        }
                    }
                    ans1++;
                }
            }
        }

        visited = new boolean[n][n];

        for (int i = 0; i < n; i++){ //적록색약인 경우
            for (int j = 0; j < n; j++){
                if (!visited[i][j]){
                    visited[i][j] = true;
                    q.add(pic[i][j]);
                    while(!q.isEmpty()){
                        Point temp = q.poll();
                        for (int k = 0; k < 4; k++){
                            int nc = temp.x + dc[k];
                            int nr = temp.y + dr[k];
                            if (nr < 0 || nr >= n || nc < 0 || nc >= n)
                                continue;
                            if (!visited[nc][nr]){
                                if (temp.color == 'R' || temp.color== 'G'){
                                    if (pic[nc][nr].color == 'R' || pic[nc][nr].color == 'G'){
                                        visited[nc][nr] = true;
                                        q.add(pic[nc][nr]);
                                    }
                                }
                                else {
                                    if (temp.color == pic[nc][nr].color){
                                        visited[nc][nr] = true;
                                        q.add(pic[nc][nr]);
                                    }
                                }
                            }

                        }
                    }
                    ans2++;
                }
            }
        }
        System.out.println(ans1 + " " + ans2);

    }
    static class Point{
        int x;
        int y;
        char color;

        Point(int _x, int _y, char _color){
            this.x = _x;
            this.y = _y;
            this.color = _color;
        }

    }
}