import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.valueOf(st.nextToken());


        for(int j = 0; j < t; j++){
            long answer = 0L;
            st = new StringTokenizer(br.readLine());
            int n = Integer.valueOf(st.nextToken());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int l = 0; l <n; l++){
                arr[l] = Integer.valueOf(st.nextToken());
            }
            int curStart = 0;
            int count = 0;
            while (true){
                if(count == n+1)
                    break;
                int maxIndex = curStart;
                for (int i = curStart; i < arr.length; i++) {
                    if (arr[i] > arr[maxIndex])
                        maxIndex = i;
                }
                if (maxIndex == 0)
                    break;
                for (int k = curStart; k <= maxIndex; k++){
                    answer += (arr[maxIndex] - arr[k]);
                }
                if(maxIndex == n - 1)
                    break;
                curStart = maxIndex+1 ;
                count++;
            }
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();



    }
}