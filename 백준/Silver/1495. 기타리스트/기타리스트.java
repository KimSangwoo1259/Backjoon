import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken()); // 곡의 개수
        int s = Integer.valueOf(st.nextToken()); // 시작 볼륨
        int m = Integer.valueOf(st.nextToken()); // 볼륨 최대크기(max)

        int arr[] = new int[m+1];

        Arrays.fill(arr, -1); // 볼륨 값이 0 일 수도 있기 때문에 -1로 초기화

        arr[s] = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++){
            int v = Integer.valueOf(st.nextToken());
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <=m; j++){
                if(arr[j] == i -1){
                    int v1 = j + v;
                    int v2 = j - v;
                    if(v1 >=0 && v1 <= m)
                        list.add(v1);
                    if(v2 >=0 && v2 <= m)
                        list.add(v2);
                }
            }
            for (int index : list) {
                arr[index] = i;
            }
        }
        int answer = -1;
        for (int i = 0; i <=m; i++){
            if(arr[i] == n)
                answer = Math.max(answer, i);
        }
        System.out.println(answer);
    }
}//TODO 다시 문제 본다음에 imagination 하기