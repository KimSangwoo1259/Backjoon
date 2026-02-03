import java.io.*;
import java.util.*;


public class Main {


    // 수열이므로 연속 될 필요는 없음. 총 원소 개수가 20 이므로 2^20 가지 이므로 총 가짓수 about 100000 이므로 브루투 포스 알고리즘으로 가능

    static int n;
    static int s;
    static int[] arr;
    static int ans;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        ans = 0;
        arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        backtrack(0,0);
        System.out.println(ans);

    }
    static void backtrack(int i, int sum){
        if (i == n)
            return;
        if (sum + arr[i] == s)
            ans++;
        backtrack(i+1,sum);
        backtrack(i+1,sum + arr[i]);
    }
}
