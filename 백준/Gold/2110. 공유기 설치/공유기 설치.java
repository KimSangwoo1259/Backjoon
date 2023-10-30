import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());
        int c = Integer.valueOf(st.nextToken());


        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++){
            arr[i] = Integer.valueOf(br.readLine());
        }
        Arrays.sort(arr);
        int left = 1;
        int right = arr[n-1] - arr[0];
        int count = 2; // 공유기 수 카운트 처음과 끝은 디폴트로 넣음
        int cur = 0; // 최근에 설치한 공유기 위치
        int mid = (left + right) / 2;
        int ans = -1;
        while (left <= right){
            for (int i = 1; i < n; i++){
                if (arr[i] - arr[cur] >= mid){
                    if (count == c - 1){
                        if (arr[n-1] - arr[i] >= mid){
                            count++;
                            cur = i;
                        }
                    }
                    else {
                        count++;
                        cur = i;
                    }
                }
            }
            if (count >= c){
                ans = Math.max(ans,mid);
                left = mid + 1;
            }
            else
                right = mid - 1;
            count = 2;
            cur = 0;
            mid = (left + right) / 2;
        }
        System.out.println(ans);
    }
}