import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.valueOf(st.nextToken());
        int end = Integer.valueOf(st.nextToken());
        boolean[] isPrime = new boolean[1000001];
        Arrays.fill(isPrime,true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= 1000000; i++){
            if(isPrime[i] == true){
                for (int j = i * i; j <= 1000000; j += i){
                    isPrime[j] = false;
                }
            }
        }
        for (int i = start; i <= end; i++){
            if(isPrime[i])
                bw.write(i + " ");

        }
        bw.flush();
        bw.close();

    }
}