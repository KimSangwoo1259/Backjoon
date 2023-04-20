import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int count = 0;
        int index = N -1;

        int[] coinArr = new int[N];
        for (int i = 0; i < N; i++){
            coinArr[i] = Integer.parseInt(br.readLine());
        }
        while(true){
            if(K >= coinArr[index]){
                K -= coinArr[index];
                count++;
                if(K == 0)
                    break;
            }
            else{
                index--;
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}