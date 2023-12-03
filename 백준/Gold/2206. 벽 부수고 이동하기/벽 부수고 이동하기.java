import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static int[][][] visited;
    static Queue<Person> q;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());

        map = new int[n][m];
        visited = new int[n][m][2];

        for (int i = 0; i < n; i++){
            String temp = br.readLine();
            for (int j = 0; j < m; j++){
                map[i][j] = temp.charAt(j) - '0';
            }
        }

        q = new LinkedList<>();
        q.add(new Person(0, 0, 0));
        visited[0][0][0] = 1;
        while (!q.isEmpty()){
            Person now = q.poll();
            if (now.x == n - 1 && now.y == m - 1){
                System.out.println(visited[now.x][now.y][now.wall]);
                return;
            }
            for (int i = 0; i < 4; i++){
                int nX = now.x + dr[i];
                int nY = now.y + dc[i];
                if (nX < 0 || nX >= n || nY <0 || nY >= m)
                    continue;
                if (visited[nX][nY][now.wall] == 0){
                    if (map[nX][nY] == 0){
                        visited[nX][nY][now.wall] = visited[now.x][now.y][now.wall] + 1;
                        q.add(new Person(nX, nY, now.wall));
                    }
                    else {
                        if (now.wall == 0){
                            visited[nX][nY][now.wall + 1] = visited[now.x][now.y][now.wall] + 1;
                            q.add(new Person(nX, nY, 1));
                        }
                    }
                }
            }


        }
        System.out.println(-1);
        return;




    }
    static class Person{
        int x,y,wall;
        Person(int x, int y,int wall){
            this.x = x;
            this.y = y;
            this.wall = wall;
        }
    }
}