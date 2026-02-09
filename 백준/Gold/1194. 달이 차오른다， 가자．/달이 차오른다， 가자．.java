import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Person {
        int x,y;
        int time;
        boolean[] keys;

        public Person(int x, int y, int time, boolean[] keys) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.keys = keys;
        }
    }

    //분명 왔단길을 다시 돌아갈 수 밖에 없음.. 그렇다고 visited 관리를 안하면 관리가 안되는데.. 가진 열쇠를 값으로 바꾸어서 visited 활용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int ans = -1;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        boolean[][][] visited = new boolean[n][m][64];
        char[][] map = new char[n][m];
        Queue<Person> q = new LinkedList<>();
        for (int i = 0; i < n; i ++){
            String str = br.readLine();
            for (int j = 0; j < m; j++){
                char temp =  str.charAt(j);
                map[i][j] = temp;
                if (temp == '0'){
                    q.add(new Person(i, j, 0, new boolean[6]));
                    visited[i][j][0] = true;
                }
            }
        }

        while(!q.isEmpty()){
            Person now = q.poll();
            if (map[now.x][now.y] == '1'){
                ans = now.time;
                break;
            }

            // 소문자는 열쇠, 대문자는 문, #는 벽, .는 이동가능
            for (int i = 0; i < 4; i++){
                int nx = now.x + dr[i];
                int ny = now.y + dc[i];
                boolean[] keys = now.keys.clone();
                int keyValue = calculateKey(keys);
                if (nx >= 0 && nx < n && ny >= 0 && ny < m){ // 범위 확인
                    if (map[nx][ny] == '.' || map[nx][ny] == '1' || map[nx][ny] == '0'){
                        if (!visited[nx][ny][keyValue]){
                            visited[nx][ny][keyValue] = true;
                            q.add(new Person(nx, ny, now.time + 1, keys));
                        }
                    }
                    else {
                        if (map[nx][ny] != '#'){ //벽이 아닌경우
                            int doorNum = map[nx][ny] - 'A';
                            int keyNum = map[nx][ny] - 'a';
                            if (keyNum >= 0) { //열쇠인 경우
                                keys[keyNum] = true;
                                keyValue = calculateKey(keys);
                                if (!visited[nx][ny][keyValue]){
                                    visited[nx][ny][keyValue] = true;
                                    q.add(new Person(nx, ny, now.time + 1, keys));
                                }

                            }
                            else { //문 인경우
                                if (keys[doorNum] && !visited[nx][ny][keyValue]){
                                    visited[nx][ny][keyValue] = true;
                                    q.add(new Person(nx, ny, now.time + 1, keys));
                                }
                            }
                        }
                    }
                }
            }
        }


        System.out.println(ans);



    }
    static int calculateKey(boolean[] keys){
        int sum = 0;
        for (int i = 0; i < keys.length; i++){
            if (keys[i])
                sum += (int) Math.pow(2, i);
        }
        return sum;
    }
}
