import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int answer = -1;
        Integer[] length = new Integer[N];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            length[i] = Integer.valueOf(st.nextToken());
        }

        Arrays.sort(length, Collections.reverseOrder());
        for(int i = 0; i < N-2; i++){
            if(length[i] < length[i+1] + length[i+2]) {
                answer = length[i] + length[i + 1] + length[i + 2];
                break;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}