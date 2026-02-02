import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static Integer[] arr;
    static Integer[] ans;
    static BufferedReader br;
    static BufferedWriter bw;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());

        arr = new Integer[n];
        ans = new Integer[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arr[i] = Integer.valueOf(st.nextToken());
        }
        Arrays.sort(arr);

        back(0);
        bw.flush();
        bw.close();

    }

    static void back(int num) throws IOException {

        if (num == m){
            for (int i = 0; i < m; i++){
                bw.write(ans[i] + " ");
            }
            bw.write("\n");
        }
        for (int i = 0; i < n; i++){
            if (!visited[i]){
                ans[num] = arr[i];
                visited[i] = true;
                back(num+1);
                visited[i] = false;
            }
        }


    }
}