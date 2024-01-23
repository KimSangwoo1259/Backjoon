import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.valueOf(br.readLine());
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        List<Integer> list = new ArrayList<>();

        int[][] arr = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++){
            String temp = br.readLine();
            for (int j = 0; j < n; j++){
                arr[i][j] = temp.charAt(j) - '0';
            }
        }
        Queue<Home> q = new LinkedList<>();
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n ; j++){
                if (arr[i][j] == 1 && !visited[i][j]){
                    int count = 0;
                    visited[i][j] = true;
                    q.add(new Home(i, j));
                    while(!q.isEmpty()){
                        count++;
                        Home now = q.poll();
                        for (int k = 0; k < 4; k++){
                            int nx = now.x + dr[k];
                            int ny = now.y + dc[k];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < n){
                                if (arr[nx][ny] == 1 && !visited[nx][ny]){
                                    q.offer(new Home(nx, ny));
                                    visited[nx][ny] = true;
                                }
                            }
                        }
                    }
                    list.add(count);
                }
            }

        }
        sb.append(list.size() + "\n");
        list.sort(Comparator.naturalOrder());

        for (int temp : list){
            sb.append(temp + "\n");
        }
        System.out.println(sb.toString());


    }
    static class Home {
        int x;
        int y;
        Home(int _x, int _y){
            this.x = _x;
            this.y = _y;
        }
    }
}