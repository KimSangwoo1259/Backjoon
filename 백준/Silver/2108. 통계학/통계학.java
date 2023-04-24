import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine());

        int arr[] = new int[N];
        int count[] = new int[8001]; // -4000 ~ 4000 까지의 Count

        int searchNum = 0;
        double temp = 0;

        int max  = -4001;
        int maxCount = 0;
        for (int i = 0; i < N; i++){
            arr[i] = Integer.valueOf(br.readLine());
            temp += arr[i];
            count[arr[i]+4000]++;

        }
        long avg = Math.round(temp/N); //평균
        Arrays.sort(arr);

        int mid = arr[(N-1)/2]; // 중앙

        int range = arr[N-1] - arr[0]; // 범위
        int appear = 0; // 최빈값 초기화
        for(int i = 0; i < 8001; i++){
            if(max < count[i])
                max = count[i];
        }


        for(int i = 0; i < 8001; i++){
            if(count[i] == max) {
                maxCount++;
                appear = i-4000;
            }
            if(maxCount == 2)
                break;

        }
        bw.write(String.valueOf(avg) + "\n" + String.valueOf(mid) + "\n" + String.valueOf(appear) + "\n" + String.valueOf(range));
        bw.flush();
        bw.close();



    }
}