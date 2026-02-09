import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {



    static class Person {
        int x;
        int y;
        int time;
        int remain;

        public Person(int x, int y, int time, int remain) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.remain = remain;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        boolean success = false;
        int ans = 0;

        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        boolean[][] visitedWithBreak = new boolean[n][m];

        for (int i = 0; i < n; i++){
            String line = br.readLine();
            for (int j = 0; j < m; j++){
                map[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        visited[0][0] = true;
        Queue<Person> q = new LinkedList<>();
        q.add(new Person(0, 0, 1, 1));

        while(!q.isEmpty()){
            Person now = q.poll();

            if (now.x == n -1 && now.y == m-1){
                ans = now.time;
                success = true;
                break;
            }
            for (int i = 0; i < 4; i++){
                int nx = now.x + dr[i];
                int ny = now.y + dc[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m){
                    if (now.remain == 1){ // 벽 부술 수 있음
                        if (map[nx][ny] == 0 && !visited[nx][ny]){
                            visited[nx][ny] = true;
                            visitedWithBreak[nx][ny] = true;

                            q.add(new Person(nx, ny, now.time + 1, now.remain));
                        }
                        else { //벽으로
                            if (!visitedWithBreak[nx][ny]) {
                                visitedWithBreak[nx][ny] = true;
                                q.add(new Person(nx, ny, now.time + 1, 0));
                            }
                        }
                    }
                    else { // 벽 부술 수 없음
                        if (map[nx][ny] == 0 && !visitedWithBreak[nx][ny]){
                            visitedWithBreak[nx][ny] = true;
                            q.add(new Person(nx, ny, now.time + 1, now.remain));
                        }

                    }
                }
            }

        }
        if (success)
            System.out.println(ans);
        else
            System.out.println(-1);
    }
}
