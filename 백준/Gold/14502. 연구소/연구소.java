import java.io.*;
import java.util.*;


public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] dc = {0, 1, 0, -1};
        int[] dr = {1, 0, -1, 0};
        int ans = 0;
        int[][] arr = new int[n][m];
        List<Table> list = new ArrayList<>();

        for (int i = 0; i <n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0) list.add(new Table(i, j));
            }
        }
        Queue<int[][]> q = new LinkedList<>();

        for (int i = 0; i < list.size() - 2; i++){
            for (int j = i+ 1; j < list.size() - 1; j++){
                for (int k = j +1; k < list.size(); k++){
                    int[][] copy = copy(arr);
                    Table first = list.get(i);
                    Table second = list.get(j);
                    Table third = list.get(k);

                    copy[first.x][first.y] = 1;
                    copy[second.x][second.y] = 1;
                    copy[third.x][third.y] = 1;
                    q.add(copy);
                }
            }
        }
        while(!q.isEmpty()){
            int[][] now = q.poll();
            Queue<Virus> virusQueue = new LinkedList<>();
            boolean[][] visited = new boolean[n][m];

            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++){
                    if (now[i][j] == 2){
                        visited[i][j] = true;
                        virusQueue.add(new Virus(i, j));
                    }
                }
            }
            while(!virusQueue.isEmpty()){
                Virus currentVirus = virusQueue.poll();
                for (int i = 0; i < 4; i++){
                    int nx = currentVirus.x + dr[i];
                    int ny = currentVirus.y + dc[i];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && now[nx][ny] == 0){
                        visited[nx][ny] = true;
                        now[nx][ny] = 2;
                        virusQueue.add(new Virus(nx, ny));
                    }
                }
            }
            int count = 0;
            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++){
                    if (now[i][j] == 0) count++;
                }
            }
            ans = Math.max(count, ans);
        }


        System.out.println(ans);

    }
    static class Table {
        int x,y;

        public Table(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] copy(int[][] arr){
        int[][] temp = new int[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++){
                temp[i][j] = arr[i][j];
            }
        }

        return temp;
    }
    static class Virus {
        int x,y;

        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }



}