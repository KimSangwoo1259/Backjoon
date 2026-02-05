import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    static class Node {
        int x;
        int y;
        int count;
        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        int ans = 10001;
        int[][] maze = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++){
            String str = br.readLine();
            for (int j = 0; j < m; j++){
                maze[i][j] = Character.getNumericValue(str.charAt(j));

            }
        }

        Queue<Node> q = new LinkedList<>();
        visited[0][0] = true;

        q.add(new Node(0, 0, 1));

        while (!q.isEmpty()){
            Node now = q.poll();
            if (now.x == n- 1 && now.y == m-1){
                ans = now.count;
                break;
            }
            for (int i = 0; i < 4; i++){
                int nx = now.x + dr[i];
                int ny = now.y + dc[i];

                if (nx >= 0 && nx < n && ny>= 0 && ny < m && !visited[nx][ny] && maze[nx][ny] == 1){
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny, now.count + 1));
                }
            }

        }

        System.out.println(ans);


    }
}
