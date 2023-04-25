import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());


        int N = Integer.valueOf(st.nextToken());

        int[] rank = new int[N];
        long answer = 0;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            rank[i] = Integer.valueOf(st.nextToken());
        }
        Arrays.sort(rank);
        for(int i = 0; i < N; i++){
            answer += Math.abs(rank[i] - (i+1));
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}