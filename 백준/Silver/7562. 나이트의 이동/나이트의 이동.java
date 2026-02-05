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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        int[] dr = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dc = {1, 2, 2, 1, -1, -2, -2, -1};

        int ans = 0;

        while(t --> 0){
            int l = Integer.parseInt(br.readLine());
            boolean[][] visited = new boolean[l][l];

            Queue<Node> q = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            int nightX = Integer.parseInt(st.nextToken());
            int nightY = Integer.parseInt(st.nextToken());

            visited[nightX][nightY] = true;
            q.add(new Node(nightX, nightY, 0));

            st = new StringTokenizer(br.readLine());

            int targetX = Integer.parseInt(st.nextToken());
            int targetY = Integer.parseInt(st.nextToken());

            while(!q.isEmpty()){
                Node now = q.poll();
                if (now.x == targetX && now.y == targetY){
                    ans = now.count;
                    break;
                }
                for (int i = 0 ; i< 8; i++){
                    int nx = now.x + dr[i];
                    int ny = now.y + dc[i];

                    if (nx >= 0 && nx < l && ny >= 0 && ny < l && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        q.add(new Node(nx, ny, now.count + 1));
                    }
                }

            }
            bw.write(ans + "\n");

        }
        bw.flush();
        bw.close();
    }
}
