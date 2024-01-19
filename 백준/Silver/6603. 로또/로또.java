import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] temp = new int[6];
    static int n;
    static BufferedWriter bw;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            n = Integer.valueOf(st.nextToken());
            if (n == 0)
                break;
            arr = new int[n];
            temp = new int[n];
            visited = new boolean[n];
            for (int i = 0; i < n; i++){
                arr[i] = Integer.valueOf(st.nextToken());
            }
            lotto(0);
            bw.write("\n");

        }
        bw.flush();
        bw.close();
    }
    static void lotto(int num) throws IOException {
        if (num == 6){
            for (int i = 0; i < 6; i++){
                bw.write(temp[i] + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = num; i < n; i++){
            if (!visited[i]){
                if (num != 0 && temp[num -1] > arr[i])
                    continue;
                visited[i] = true;
                temp[num] = arr[i];
                lotto(num + 1);
                visited[i] = false;
            }
        }

    }
}