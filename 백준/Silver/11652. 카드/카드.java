import java.io.*;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        long[] card = new long[n];
        for (int i = 0; i < n; i++){
            card[i] = Long.valueOf(br.readLine());
        }
        Arrays.sort(card);
        int maxCount = 1;
        long manyValue = card[0];
        int curCount = 1;
        for (int i = 1; i < n; i++){
            if (card[i] == card[i-1]){
                curCount++;
            }
            else{
                curCount = 1;

            }
            if (curCount > maxCount){
                maxCount = curCount;
                manyValue = card[i];
            }
        }

        System.out.println(manyValue);

    }
}