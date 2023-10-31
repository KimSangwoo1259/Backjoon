import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.valueOf(st.nextToken());
        int p = Integer.valueOf(st.nextToken());

        String str = br.readLine();

        char[] arr = new char[s];

        for (int i = 0; i < s; i++){
            arr[i] = str.charAt(i);
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.valueOf(st.nextToken());
        int c = Integer.valueOf(st.nextToken());
        int g = Integer.valueOf(st.nextToken());
        int t = Integer.valueOf(st.nextToken());

        int ans = 0;

        int startL = 0;
        int startR = p-1;

        int aCount = 0;
        int cCount = 0;
        int gCount = 0;
        int tCount = 0;

        for (int i = startL; i <= startR; i++){
            switch (arr[i]){
                case 'A':
                    aCount++;
                    break;
                case 'C':
                    cCount++;
                    break;
                case 'G':
                    gCount++;
                    break;
                default:
                    tCount++;
                    break;
            }


        }
        startL++;
        startR++;
        if (aCount >= a && cCount >= c && gCount >= g && tCount >= t)
            ans++;

        while (startR < s){
            switch (arr[startL-1]){
                case 'A':
                    aCount--;
                    break;
                case 'C':
                    cCount--;
                    break;
                case 'G':
                    gCount--;
                    break;
                default:
                    tCount--;
                    break;
            }
            switch (arr[startR]){
                case 'A':
                    aCount++;
                    break;
                case 'C':
                    cCount++;
                    break;
                case 'G':
                    gCount++;
                    break;
                default:
                    tCount++;
                    break;
            }
            if (aCount >= a && cCount >= c && gCount >= g && tCount >= t)
                ans++;

            startL++;
            startR++;

        }

        System.out.println(ans);


    }


}