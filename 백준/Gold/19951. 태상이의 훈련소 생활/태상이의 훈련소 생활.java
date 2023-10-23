import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken()); // 연병장 크기
        int m = Integer.valueOf(st.nextToken()); // 조교 수

        int[] arr = new int[n+1];
        int[] delta = new int[n + 1];
        int[] sumDel = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++){
            arr[i] = Integer.valueOf(st.nextToken());
        }
        int s;
        int e;
        int k;
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            s = Integer.valueOf(st.nextToken());
            e = Integer.valueOf(st.nextToken());
            k = Integer.valueOf(st.nextToken());
            delta[s] += k;
            if (e != n)
                delta[e+1] += -k;
        }

        for (int i = 1; i <=n; i++){
            sumDel[i] = sumDel[i - 1] + delta[i];
            arr[i] += sumDel[i];
            bw.write(arr[i] + " ");
        }

        bw.flush();
        bw.close();
    }
}