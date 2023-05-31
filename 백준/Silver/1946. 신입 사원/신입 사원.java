import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.valueOf(st.nextToken());
        for (int j = 0; j < t; j++){

            st = new StringTokenizer(br.readLine());
            int n = Integer.valueOf(st.nextToken());
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.valueOf(st.nextToken());
                arr[i][1] = Integer.valueOf(st.nextToken());
            }
            Arrays.sort(arr, Comparator.comparingInt(o -> o[0])); //서류 점수로 sort
            int min = arr[0][1]; //면접 점수의 최소 등수
            int count = 1;
            for (int i = 1; i < n; i++){
                if(arr[i][1] < min){
                    count++;
                    min = arr[i][1];
                }
            }
            bw.write(String.valueOf(count) + '\n');
        }
        bw.flush();
        bw.close();
    }
}