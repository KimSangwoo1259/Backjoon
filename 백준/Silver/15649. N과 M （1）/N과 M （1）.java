import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] arr;
    static boolean[] visited;
    static BufferedWriter bw;
    static BufferedReader br;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());

        arr = new int[m + 1];
        visited = new boolean[n + 1];

        recursion(0);

        bw.flush();
        bw.close();

    }
    static void recursion(int k) throws IOException {
        if (k == m){
            for (int i = 0; i < m; i++){
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = 1; i <= n; i++){
            if(!visited[i]){
                arr[k] = i;
                visited[i] = true;
                recursion(k+1);
                visited[i] = false;
            }
        }
    }
}