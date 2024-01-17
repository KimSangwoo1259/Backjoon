import java.io.*;

public class Main {
    static boolean[] visited;
    static int[] arr;
    static int n;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

       n = Integer.valueOf(br.readLine());


        arr = new int[n];
        visited = new boolean[n+1];
        recursion(0);
        bw.flush();
        bw.close();

    }
    static void recursion(int m) throws IOException {
        if (m == n){
            for (int i = 0; i < n; i++){
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = 1; i <= n; i++){
            if (!visited[i]){
                arr[m] = i;
                visited[i] = true;
                recursion(m + 1);
                visited[i] = false;
            }
        }
    }

}
