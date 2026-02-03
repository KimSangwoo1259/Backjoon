import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] arr;
    static boolean[] visited;
    static int ans = Integer.MAX_VALUE;
    // i번째의 숫자는 n * Math.pow(2,n-i) <= m 이어야 한다. 안그러면 볼 것도 없음
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n];


        for (int i = 0; i < n; i ++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++){
            visited[i] = true;
            travel(i,i,0,0);
            visited[i] = false;
        }
        System.out.println(ans);

    }

    private static void travel(int start, int before, int level, int cost) {
        if (level == n - 1){
            if (arr[before][start] == 0) {
                return;
            }
            ans = Math.min(ans, cost + arr[before][start]);

        }

        for (int i = 0; i < n; i++){
            if (i == before || arr[before][i] == 0 || visited[i])
                continue;
            visited[i] = true;
            travel(start,i,level+1,cost + arr[before][i]);
            visited[i] = false;

        }
    }


}
