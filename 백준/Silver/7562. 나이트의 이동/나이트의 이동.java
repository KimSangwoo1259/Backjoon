import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int l;
    static int[][] chess;
    static boolean[][] visited;
    static int[] dr = {2, 2, 1, 1, -1, -1, -2, -2};
    static int[] dc = {-1, 1, -2, 2, -2, 2, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.valueOf(br.readLine());

        StringTokenizer st;

       while (t--> 0){
            l = Integer.valueOf(br.readLine());
            chess = new int[l][l];
            visited = new boolean[l][l];
            st = new StringTokenizer(br.readLine());
            int curX = Integer.valueOf(st.nextToken());
            int curY = Integer.valueOf(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int targetX = Integer.valueOf(st.nextToken());
            int targetY = Integer.valueOf(st.nextToken());
            Queue<Chess> q = new LinkedList<>();
            visited[curX][curY] = true;
            q.add(new Chess(curX, curY, 0));

            while (!q.isEmpty()){
                Chess now = q.poll();
                if (now.x == targetX && now.y == targetY){
                    bw.write(now.level + "\n");
                    break;
                }
                for (int i = 0; i < 8; i++){
                    int nextX = now.x + dr[i];
                    int nextY = now.y + dc[i];
                    if (nextX < 0 || nextX >= l ||nextY < 0 || nextY >= l) continue;

                    if (!visited[nextX][nextY]) {
                        q.add(new Chess(nextX, nextY, now.level + 1));
                        visited[nextX][nextY] = true;
                    }
                }
            }

        }
        bw.flush();
        bw.close();



    }
    static class Chess{
        int x,y,level;

        Chess(int x, int y, int level){
            this.x = x;
            this.y = y;
            this.level = level;
        }
    }

}