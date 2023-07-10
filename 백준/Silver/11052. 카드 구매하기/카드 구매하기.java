import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.valueOf(br.readLine());

        int p[] = new int[n+1];
        int d[] = new int[n + 1]; // n개살때의 가격 최대 값을 저장한 배열

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i= 1; i<=n; i++){
            p[i] = Integer.valueOf(st.nextToken());
        }
        for (int i = 1; i <=n; i++){
            for (int j = 1; j <=i; j++){
                d[i] = Math.max(d[i], d[i-j] + p[j]);
            }
        }
        System.out.println(d[n]);

    }
}
// d[1] = d[0] + p[1] // d[2] = d[0] + p[2] or d[1] + p[1]