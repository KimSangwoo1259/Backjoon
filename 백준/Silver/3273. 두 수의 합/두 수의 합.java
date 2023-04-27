import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());

        int answer = 0;

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.valueOf(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int x = Integer.valueOf(st.nextToken());
        Arrays.sort(arr);
        int start = 0;
        int end = n-1;
        while(start < end){
            if(arr[start] + arr[end] == x){
                answer++;
                start++;
                end--;
            }
            else if(arr[start] + arr[end] < x){
                start++;
            }
            else{
                end--;
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}