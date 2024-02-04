import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int dr[] = {1, 0, -1, 0};
        int dc[] = {0, 1, 0, -1};

        int h = Integer.valueOf(st.nextToken());
        int w = Integer.valueOf(st.nextToken());

        char[][] island = new char[h][w];
        int max = 0;
        for (int i = 0; i < h; i++){
            String str = br.readLine();
            for (int j = 0; j < w; j++){
                island[i][j] = str.charAt(j);
            }
        }
        for (int i = 0; i < h; i++){
            for (int j = 0; j < w; j++){
                if (island[i][j] == 'L'){
                    Queue<W> q = new LinkedList<>();
                    boolean[][] visited = new boolean[h][w];
                    q.offer(new W(i, j, 0));
                    visited[i][j] = true;
                    while (!q.isEmpty()){
                        W now = q.poll();
                        max = Math.max(now.time, max);
                        for (int k = 0; k < 4; k++){
                            int nx = now.x + dr[k];
                            int ny = now.y + dc[k];
                            if (nx >= 0 && nx < h && ny >= 0 && ny < w){
                                if (!visited[nx][ny] && island[nx][ny] == 'L'){
                                    q.offer(new W(nx, ny, now.time + 1));
                                    visited[nx][ny] = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(max);

    }
    static class W {
        int x,y,time;
        W(int _x, int _y, int t){
            x = _x;
            y = _y;
            time = t;
        }
    }
}
