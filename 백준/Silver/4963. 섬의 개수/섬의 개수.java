import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int w;
    static int h;
    static int[][] island;
    static boolean[][] visited;
    static int answer;
    static int[] dh = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dw = {0, 1, 1, 1, 0, -1, -1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        while (true){
            st = new StringTokenizer(br.readLine());
            w = Integer.valueOf(st.nextToken());
            h = Integer.valueOf(st.nextToken());
            if (w == 0 && h == 0){
                break;
            }
            answer = 0;
            island = new int[h][w];
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++){
                    island[i][j] = Integer.valueOf(st.nextToken());
                }
            }
            Queue<Land> q = new LinkedList<>();
            for (int i = 0; i < h; i++){
                for (int j = 0; j < w; j++){
                    if (island[i][j] == 1 && !visited[i][j]){
                        answer++;
                        q.offer(new Land(i, j));
                        while (!q.isEmpty()){
                            Land now = q.poll();
                            for (int k = 0; k < 8; k++){
                                int nX = now.x + dh[k];
                                int nY = now.y + dw[k];

                                if (nX >= 0 && nX < h && nY >=0 && nY < w) {
                                    if (!visited[nX][nY] && island[nX][nY] == 1) {
                                        q.offer(new Land(nX, nY));
                                        visited[nX][nY] = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            bw.write(answer + "\n");

        }
        bw.flush();
        bw.close();
    }
}
class Land {
    int x,y;
    Land(int _x, int _y){
        x = _x;
        y = _y;
    }
}