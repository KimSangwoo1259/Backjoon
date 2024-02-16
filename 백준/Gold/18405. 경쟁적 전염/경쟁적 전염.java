import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());
        int k = Integer.valueOf(st.nextToken());
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        int[][] map = new int[n][n];
        Queue<Virus>[] qList = new Queue[k + 1];
        for (int i = 1; i <= k; i++) {
            qList[i] = new LinkedList<>();
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.valueOf(st.nextToken());
                if (map[i][j] != 0) {
                    qList[map[i][j]].add(new Virus(i, j, 0));

                }
            }
        }


        st = new StringTokenizer(br.readLine());
        int s = Integer.valueOf(st.nextToken());
        int x = Integer.valueOf(st.nextToken());
        int y = Integer.valueOf(st.nextToken());
        boolean isEnd = false;
        for (int w = 0; w < s; w++){
            for (int j = 1; j <= k && !isEnd; j++) {
                List<Virus> list = new ArrayList<>();
                while (!qList[j].isEmpty() && !isEnd) {
                    Virus now = qList[j].poll();
                    if (now.s == s + 1){
                        isEnd = true;
                        break;
                    }
                    for (int q = 0; q < 4; q++) {
                        int nx = now.x + dr[q];
                        int ny = now.y + dc[q];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                            if (map[nx][ny] == 0) {
                                map[nx][ny] = j;
                                if (nx == x-1 && ny == y-1) {
                                    isEnd = true;
                                    break;
                                }
                                list.add(new Virus(nx, ny, now.s + 1));
                            }
                        }
                    }
                }
                for (Virus v : list){
                    qList[j].offer(v);
                }
            }
        }
        System.out.println(map[x-1][y-1]);
    }
    static class Virus{
        int x, y,s;
        Virus(int _x, int _y, int _s){
            x = _x;
            y = _y;
            s = _s;
        }
    }
} //todo
