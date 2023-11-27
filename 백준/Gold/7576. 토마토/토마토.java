import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] preTomato;
    static int[][] tomato;
    static boolean[][] visited;
    static int m;
    static int n;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int ans = 0;
    static int count = 0;
    static int ansTime = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int minus = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.valueOf(st.nextToken());
        n = Integer.valueOf(st.nextToken());
        tomato = new int[n][m];
        preTomato = new int[n][m];
        visited = new boolean[n][m];
        Queue<Tomato> q = new LinkedList<>();
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                tomato[i][j] = Integer.valueOf(st.nextToken());
                if (tomato[i][j] == -1)
                    minus++;
                if (tomato[i][j] == 1){
                    q.add(new Tomato(i, j,0));
                    visited[i][j] = true;
                    count++;
                }
            }
        }
        ans = n * m - minus; // 익을 수 있는 총 토마토 개수
        preTomato = tomato;
        if (count == ans){
            System.out.println(ansTime);
            System.exit(0);
        }


        while (!q.isEmpty()){
            Tomato now = q.poll();
            for (int i = 0; i < 4; i++){
                int nextX = now.x + dr[i];
                int nextY = now.y + dc[i];
                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m || tomato[nextX][nextY] == -1) continue;

                if (!visited[nextX][nextY]){
                    count++;
                    visited[nextX][nextY] = true;
                    q.add(new Tomato(nextX, nextY, now.time + 1));
                    ansTime = Math.max(ansTime, now.time + 1);
                }
            }
        }
        if (count != ans){
            System.out.println(-1);
        }
        else {
            System.out.println(ansTime);
        }

    }
}
// 전 토마토 상태를 저장해놓고 그 기준으로 토마토 전파, 처음에 총 개수를 파악해야함

class Tomato {
    int x,y,time;
    Tomato(int x, int y, int time){
        this.x = x;
        this.y = y;
        this.time = time;
    }
}