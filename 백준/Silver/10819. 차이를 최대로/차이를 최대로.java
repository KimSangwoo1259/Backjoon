import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;
    static int[] temp;
    static boolean[] visited;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.valueOf(br.readLine());
        arr = new int[n];
        visited = new boolean[n];
        temp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arr[i] = Integer.valueOf(st.nextToken());
        }
        getMaxDif(0);
        System.out.println(answer);

    }
    static void getMaxDif(int num){
        if (num == n) {
            int tempSum = 0;
            for (int i = 0; i < n -1 ; i++){
                tempSum += Math.abs(temp[i] - temp[i + 1]);
            }
            answer = Math.max(answer, tempSum);
            return;
        }
        for (int i = 0; i < n; i++){
            if (!visited[i]){
                temp[num] = arr[i];
                visited[i] = true;
                getMaxDif(num + 1);
                visited[i] = false;
            }
        }
    }
}
