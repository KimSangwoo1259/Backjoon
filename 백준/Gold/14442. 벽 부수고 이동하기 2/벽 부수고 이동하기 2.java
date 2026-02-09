import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {



    static class Person {
        int x;
        int y;
        int time;
        int count;

        public Person(int x, int y, int time, int count) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.count = count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        boolean success = false;
        int ans = 0;

        int[][] map = new int[n][m];
        boolean[][][] visited = new boolean[n][m][k + 1];

        for (int i = 0; i < n; i++){
            String line = br.readLine();
            for (int j = 0; j < m; j++){
                map[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        visited[0][0][0] = true;
        Queue<Person> q = new LinkedList<>();
        q.add(new Person(0, 0, 1, 0));

        while(!q.isEmpty()){
            Person now = q.poll();

            if (now.x == n -1 && now.y == m-1){
                ans = now.time;
                success = true;
                break;
            }
            for (int i = 0; i < 4; i ++){
                int nx = now.x + dr[i];
                int ny = now.y + dc[i];

                if (nx >= 0 && nx < n && ny >=0 && ny < m){
                    int value = map[nx][ny];

                    if (value == 0){
                        if (!visited[nx][ny][now.count]) {
                            visited[nx][ny][now.count] = true;
                            q.add(new Person(nx, ny, now.time + 1, now.count));
                        }
                    }
                    else { // 벽인 경우
                        if (now.count < k && !visited[nx][ny][now.count + 1]){
                            visited[nx][ny][now.count + 1] = true;
                            q.add(new Person(nx, ny, now.time + 1, now.count + 1));
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
