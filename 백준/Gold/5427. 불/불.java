import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    //이미 불이 난칸, 혹은 불이 나려는 칸은 못간다. 미리 불을 옮기고 움직이자.
    // 탈출 한다는거는 경계 쪽에 도착을 성공해야하고 그 다음 1초뒤에 가능.
    static class Fire {
        int x;
        int y;

        public Fire(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static class Person {
        int x;
        int y;
        int time;

        public Person(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while(t --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            boolean success = false;
            char[][] building = new char[h][w];
            boolean[][] visited = new boolean[h][w];
            int ans = 0;
            final String failMessage = "IMPOSSIBLE";
            Queue<Fire> fireQueue = new LinkedList<>();
            Queue<Person> personQueue = new LinkedList<>();
            Queue<Fire> nextFireQueue = new LinkedList<>();
            Queue<Person> nextPersonQueue = new LinkedList<>();

            for (int i = 0; i < h; i ++){
                String str = br.readLine();
                for (int j = 0; j < w; j++){
                    char temp = str.charAt(j);
                    building[i][j] = temp;
                    if (temp == '@'){
                        personQueue.add(new Person(i, j, 1)); // 계산 편의상 경계에 다다르면 탈출 이라는 가정으로 1로 시작
                        visited[i][j] = true;
                    }
                    else if (temp == '*'){
                        fireQueue.add(new Fire(i, j));
                    }
                }
            }
            while(!personQueue.isEmpty() || !nextPersonQueue.isEmpty()){
                while(!fireQueue.isEmpty()){
                    Fire now = fireQueue.poll();

                    for (int i = 0; i < 4; i++){
                        int nx = now.x + dr[i];
                        int ny = now.y + dc[i];

                        if (nx >= 0 && nx <h && ny >= 0 && ny < w && (building[nx][ny] == '.' || building[nx][ny] == '@')){
                            building[nx][ny] = '*';
                            nextFireQueue.add(new Fire(nx, ny));
                        }

                    }
                }
                while(!personQueue.isEmpty()){
                    Person now = personQueue.poll();
                    if (now.x == h -1 || now.x == 0 || now.y == 0 ||  now.y == w - 1){
                        success = true;
                        ans = now.time;
                        personQueue.clear();
                        nextPersonQueue.clear();
                        break;
                    }


                    for (int i = 0; i < 4; i++){
                        int nx = now.x + dr[i];
                        int ny = now.y + dc[i];
                        if (nx >= 0 && nx <h && ny >= 0 && ny < w && building[nx][ny] == '.' && !visited[nx][ny]){
                            visited[nx][ny] = true;
                            nextPersonQueue.add(new Person(nx, ny, now.time + 1));
                        }
                    }
                }
                fireQueue.addAll(nextFireQueue);
                personQueue.addAll(nextPersonQueue);
                nextFireQueue.clear();
                nextPersonQueue.clear();
            }

            if (success){
                System.out.println(ans);
            }
            else {
                System.out.println(failMessage);
            }


        }

    }
}
