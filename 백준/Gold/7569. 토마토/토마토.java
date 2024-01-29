import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.valueOf(st.nextToken());
        int n = Integer.valueOf(st.nextToken());
        int h = Integer.valueOf(st.nextToken());
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        int maxSpace = 0;
        int curTomato = 0;
        int[][][] box = new int[n][m][h];
        Queue<Tomato> q = new LinkedList<>();
        boolean visited[][][] = new boolean[n][m][h];
        int answer = 0;
        for (int i = 0; i < h; i++){
            for (int j = 0; j < n; j++){
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++){
                    int temp = Integer.valueOf(st.nextToken());
                    if (temp != -1){
                        maxSpace++;
                    }
                    box[j][k][i] = temp;
                    if (temp == 1) {
                        q.offer(new Tomato(j, k, i, 0));
                        visited[j][k][i] = true;
                        curTomato++;
                    }
                }
            }
        }
        if (curTomato == maxSpace) {
            System.out.println(0);
            return;
        }

        while (!q.isEmpty()){
            Tomato now = q.poll();
            answer = Math.max(now.day, answer);
            for (int i = 0; i < 4; i++){
                int nx = now.n + dr[i];
                int ny = now.m + dc[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (box[nx][ny][now.h] == 0 && !visited[nx][ny][now.h]) {
                        box[nx][ny][now.h] = 1;
                        visited[nx][ny][now.h] = true;
                        q.offer(new Tomato(nx, ny, now.h, now.day + 1));
                        curTomato++;
                    }
                }
                if (now.h > 0){
                    if (box[now.n][now.m][now.h-1] == 0 && !visited[now.n][now.m][now.h-1]){
                        box[now.n][now.m][now.h-1] = 1;
                        visited[now.n][now.m][now.h-1] = true;
                        q.offer(new Tomato(now.n, now.m, now.h-1, now.day + 1));
                        curTomato++;
                    }
                }
                if (now.h < h - 1){
                    if (box[now.n][now.m][now.h+1] == 0 && !visited[now.n][now.m][now.h+1]){
                        box[now.n][now.m][now.h+1] = 1;
                        visited[now.n][now.m][now.h+1] = true;
                        q.offer(new Tomato(now.n, now.m, now.h+1, now.day + 1));
                        curTomato++;
                    }
                }
            }
        }
        if (maxSpace != curTomato)
            System.out.println(-1);
        else
            System.out.println(answer);

    }
    static class Tomato {
        int n,m,h,day;
        Tomato(int _n, int _m, int _h, int _d) {
            n = _n;
            m = _m;
            h = _h;
            day = _d;
        }
    }
}

