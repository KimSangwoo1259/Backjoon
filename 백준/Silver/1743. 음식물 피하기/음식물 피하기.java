import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[][] trash = new boolean[n][m];
        boolean[][] visited = new boolean[n][m];

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        int ans = 0;
        Queue<Trash> q = new LinkedList<>();
        for (int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            trash[a-1][b-1] = true;

        }

        for (int i = 0 ; i < n; i++){
            for (int j = 0; j < m; j++){
                if (trash[i][j] && !visited[i][j]){
                    int count = 0;
                    visited[i][j] = true;
                    q.add(new Trash(i, j));
                    while(!q.isEmpty()){
                        Trash now = q.poll();
                        count++;
                        for (int l = 0; l < 4; l++){
                            int nx = now.x + dr[l];
                            int ny = now.y + dc[l];

                            if (nx >= 0 && nx < n && ny >=0 && ny < m && !visited[nx][ny] && trash[nx][ny]){
                                visited[nx][ny] = true;
                                q.add(new Trash(nx, ny));
                            }
                        }
                    }
                    ans = Math.max(count, ans);
                }
            }
        }
        System.out.println(ans);


    }
    static class Trash {
        int x, y;
        public Trash(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
