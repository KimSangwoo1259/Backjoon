import java.io.*;
import java.util.*;

public class Main {
    static char[][] building;
    static boolean[][] visited;
    static boolean[][] fireVisited;
    static int w;
    static int h;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static boolean exited;;
    static Queue<Fire> fires;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.valueOf(br.readLine());
        StringTokenizer st;
        while (t --> 0){
            int curTime = 0;
            st = new StringTokenizer(br.readLine());
            exited = false;
            w = Integer.valueOf(st.nextToken());
            h = Integer.valueOf(st.nextToken());
            building = new char[h][w];
            visited = new boolean[h][w];
            fireVisited = new boolean[h][w];
            Queue<Person> q = new LinkedList<>();
            fires = new LinkedList<>();
            for (int i = 0; i < h; i++){
                String str = br.readLine();
                for (int j = 0; j < w; j++){
                    building[i][j] = str.charAt(j);
                    if (building[i][j] == '@'){
                        q.add(new Person(i, j, 0));
                        visited[i][j] = true;
                    }
                    if (building[i][j] == '*'){
                        fires.add(new Fire(i, j));
                        fireVisited[i][j] = true;
                    }
                }
            }
            expand();
            while (!q.isEmpty()){
                Person now = q.poll();
                if (curTime != now.time){
                    curTime++;
                    expand();
                }
                if (isExited(now)){
                    bw.write(now.time + "\n");
                    break;
                }
                for (int i = 0; i < 4; i++){
                    int nX = now.x + dr[i];
                    int nY = now.y + dc[i];

                    if (isExited(new Person(nX, nY, now.time + 1))){
                        bw.write(now.time + 1 + "\n");
                        exited = true;
                        break;
                    }

                    if (building[nX][nY] == '.' && !visited[nX][nY]){
                        q.add(new Person(nX, nY, now.time + 1));
                        visited[nX][nY] = true;
                    }
                }
                if (exited)
                    break;
            }
            if (!exited)
                bw.write("IMPOSSIBLE" + "\n");

        }
        bw.flush();
        bw.close();
    }
    static class Person {
        int x,y,time;

        Person(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    static class Fire{
        int x,y;
        Fire(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Fire fire = (Fire) o;
            return x == fire.x && y == fire.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    static void expand(){
        int size = fires.size();
        for (int i = 0; i < size; i++){
            Fire now = fires.poll();
            for (int k = 0; k < 4; k++){
                int nextI = now.x + dr[k];
                int nextJ = now.y + dc[k];
                if (nextI < 0 || nextI >= h || nextJ < 0 || nextJ >= w || building[nextI][nextJ] == '#' || fireVisited[nextI][nextJ])
                    continue;
                building[nextI][nextJ] = '*';
                fires.add(new Fire(nextI, nextJ));
                fireVisited[nextI][nextJ] = true;
            }
        }
    }
    static boolean isExited(Person now){
        if (now.x < 0 || now.x >= h || now.y < 0 || now.y >= w)
            return true;
        return false;
    }


}
