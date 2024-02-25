import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dr = {-1, 0, 1, 0,};
        int[] dc = {0, 1, 0, -1};
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.valueOf(st.nextToken());
        int c = Integer.valueOf(st.nextToken());
        char[][] map = new char[r][c];
        Queue<Water> wq = new LinkedList<>();
        Queue<Beaver> bq = new LinkedList<>();
        boolean[][] visited = new boolean[r][c];
        boolean[][] water = new boolean[r][c];
        int ans = 0;
        for (int i = 0; i < r; i++){
            String temp = br.readLine();
            for (int j = 0; j < c; j++){
                char t = temp.charAt(j);
                map[i][j] = t;
                if (t == '*') {
                    wq.offer(new Water(i, j));
                    water[i][j] = true;
                }
                else if (t == 'S') {
                    bq.offer(new Beaver(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }
        boolean founded = false;
        while (!founded){
            List<Water> tempW = new ArrayList<>();
            List<Beaver> tempB = new ArrayList<>();
            while (!wq.isEmpty()){
                Water now = wq.poll();
                for (int i = 0; i <4; i++){
                    int nx = now.x + dr[i];
                    int ny = now.y + dc[i];
                    if (nx >= 0 && nx < r && ny >= 0 && ny < c){
                        if (!water[nx][ny] && map[nx][ny] == '.'){
                            water[nx][ny] = true;
                            tempW.add(new Water(nx, ny));
                        }
                    }
                }
            }
            for(Water w : tempW){
                map[w.x][w.y] = '*';
                wq.offer(w);
            }
            while (!bq.isEmpty()){
                Beaver now = bq.poll();
                for (int i = 0; i <4; i++){
                    int nx = now.x + dr[i];
                    int ny = now.y + dc[i];
                    if (nx >= 0 && nx < r && ny >= 0 && ny < c){
                        if (map[nx][ny] == 'D'){
                            founded = true;
                            ans = now.time + 1;
                            break;
                        }
                        if (!visited[nx][ny] && map[nx][ny] == '.'){
                            visited[nx][ny] = true;
                            tempB.add(new Beaver(nx, ny, now.time + 1));

                        }
                    }
                }
            }
            if (tempB.isEmpty())
                break;
            for (Beaver b : tempB){
                bq.offer(b);
            }
        }
        if (founded)
            System.out.println(ans);
        else
            System.out.println("KAKTUS");
    }
    static class Water {
        int x, y;
        Water(int _x, int _y){
            x = _x;
            y = _y;
        }
    }
    static class Beaver {
        int x, y, time;
        Beaver(int _x, int _y, int t){
            x = _x;
            y = _y;
            time = t;
        }

    }
}
// 일단 시작할때 물을 먼저 전파 시켜야함 -> 물이 들어올 예정인 곳도 못가니까
// 그리고 고슴도치는 *일때만 움직일 수 있다.
// 물 전파 -> 고슴도치 이동 -> 새로 발생된 비버들은 임시 리스트에 이동; 큐가 다 빠질때 까지 한 다음에 다시 큐에 리스트에 있는거 넣기