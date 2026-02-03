import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] arr;
    static int p;
    static int m;
    static int t;
    static int d;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());

        p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        backtrack(1, arr[0]);

        System.out.println(max + "\n" + min);
    }

     static void backtrack(int l, int value) {
        if (l == n){
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        }
        if (p > 0){
            p--;
            backtrack(l + 1,value + arr[l]);
            p++;
        }
        if (m > 0){
             m--;
             backtrack(l + 1,value - arr[l]);
             m++;
         }
        if (t > 0){
             t--;
             backtrack(l + 1,value * arr[l]);
             t++;
         }
        if (d > 0){
             d--;
             backtrack(l + 1,value / arr[l]);
             d++;
         }

    }
}
