import java.io.*;
import java.util.StringTokenizer;

public class Main {


    // 힌트 얻고 푼 문제 이므로 얼마뒤에 한번 더 풀어보기
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] delta = new int[n];
        int[] accDelta = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < m; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            delta[a-1] += h;
            if (b < n){
                delta[b] -= h;
            }
        }
        accDelta[0] = delta[0];
        for (int i = 1; i < n; i ++){
            accDelta[i] = accDelta[i - 1] + delta[i];
        }
        for (int i = 0; i < n; i++){
            int temp = arr[i] + accDelta[i];
            bw.write(temp + " ");

        }
        bw.flush();
        bw.close();


    }
}