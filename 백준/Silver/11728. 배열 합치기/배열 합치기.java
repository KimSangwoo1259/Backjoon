import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());

        int[] arr1 = new int[n];
        int[] arr2 = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arr1[i] = Integer.valueOf(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++){
            arr2[i] = Integer.valueOf(st.nextToken());
        }

        int[] mergedArr = new int[n + m];
        int index1 = 0;
        int index2 = 0;
        int index = 0;
        while (index1 < n && index2 < m){
            if (arr1[index1] > arr2[index2]){
                mergedArr[index++] = arr2[index2++];
            }
            else {
                mergedArr[index++] = arr1[index1++];
            }
        }
        if (index1 <= n- 1){
            for (int i = index1; i < n; i++){
                mergedArr[index++] = arr1[i];
            }
        }
        if (index2 <= m - 1){
            for (int i = index2; i < m; i++){
                mergedArr[index++] = arr2[i];
            }
        }
        for (int i = 0; i < n + m; i++){
            bw.write(mergedArr[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}