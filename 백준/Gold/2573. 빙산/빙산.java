import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = 0;
        int[][] snow = new int[n][m];
        int[][] temp = new int[n][m];
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                snow[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        while(true){
            temp = new int[n][m];
            boolean[][] visited = new boolean[n][m];
            int count = 0;
            // 연결수 계산
            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++){
                    if (!visited[i][j] && snow[i][j] != 0){
                        count++;
                        visited[i][j] = true;
                        Queue<Node> q = new LinkedList<>();
                        q.add(new Node(i,j));
                        while(!q.isEmpty()){
                            Node now = q.poll();
                            for (int k = 0; k < 4; k++){
                                int nx = now.x + dr[k];
                                int ny = now.y + dc[k];
                                if (nx >= 0 && nx < n && ny >= 0 && ny < m && snow[nx][ny] != 0 && !visited[nx][ny]){
                                    visited[nx][ny] = true;
                                    q.add(new Node(nx, ny));
                                }
                            }
                        }

                    }
                }
            }
            if (count == 0){ // 연결 요소가 0 이라는건 모두 0 이라는 뜻이므로
                t = 0;
                break;
            }
            if (count > 1){ // 두덩이 이상이므로
                break;
            }

            //주변 바다 개수 에 따른 빙산 높이 재조정 데이터 삽입
            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++){
                    if (snow[i][j] != 0){
                        for (int k = 0; k < 4; k++){
                            int nx = i + dr[k];
                            int ny = j + dc[k];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < m){
                                if (snow[nx][ny] == 0){
                                    temp[i][j]--;
                                }
                            }
                        }
                    }
                }
            }

            // 데이터에 따라 빙산 높이 조정
            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++){
                    snow[i][j] = Math.max(0, snow[i][j] + temp[i][j]);
                }
            }
            t++;
        }
        System.out.println(t);
    }
}