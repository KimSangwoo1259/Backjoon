import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    static class Node {
        int x;
        int y;
        int time;
        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] box = new int[n][m];

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        int target = n * m;
        int curCount = 0;
        int time = 0;
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                int value = Integer.parseInt(st.nextToken());
                box[i][j] = value;
                if (value == -1)
                    target--;
                else if (value == 1) {
                    curCount++;
                    q.add(new Node(i, j, 0));
                }
            }
        }
        if (target == curCount){
            System.out.println(0);
            return;
        }

        while(!q.isEmpty()){
            Node now = q.poll();
            for (int i = 0; i < 4; i++){
                int nx = now.x + dr[i];
                int ny = now.y + dc[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny< m && box[nx][ny] == 0){
                    q.add(new Node(nx, ny, now.time + 1));
                    box[nx][ny] = 1;
                    curCount++;
                    if (curCount == target){
                        time = now.time + 1;
                        break;
                    }
                }
            }
        }

        if (curCount == target) {
            System.out.println(time);
        }

        else
            System.out.println(-1);

    }
}
