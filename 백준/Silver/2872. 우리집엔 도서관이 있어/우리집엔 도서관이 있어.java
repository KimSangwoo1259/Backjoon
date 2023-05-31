import java.io.*;
import java.util.StringTokenizer;

//제일 큰수부터 앞으로 가면서 순서대로 줄어드는 수열이 있는지 확인
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());
        int maxIndex = 0;

        int count = 1; //순서대로 줄어드는 수열의 크기
        int arr[] = new int[n];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.valueOf(st.nextToken());
            if(arr[i]== n)
                maxIndex = i;
        }
        for (int i = maxIndex; i >=0; i--){
            if(arr[maxIndex] - count == arr[i])
                count++;
        }

        bw.write(String.valueOf(n-count));
        bw.flush();
        bw.close();

    }
}