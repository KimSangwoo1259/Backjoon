import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());
        int r = Integer.valueOf(st.nextToken());
        int c = Integer.valueOf(st.nextToken());

        count = 0;
        z(n, r, c);
        System.out.println(count);
    }
    static void z(int n,int r,int c){
        int length = 1 << n;
        int mid = length /2;
        if (n == 0)
            return;


        if (r < mid && c < mid) {// 좌측 상단
            z(n - 1, r, c);
        }
        else if(r < mid && c >=mid) {
            count += mid * mid ;// 우측 상단
            z(n - 1, r, c - (length / 2));
        }
        else if(r >= mid && c < mid) { // 좌측 하단
            count += mid * mid * 2;
            z(n - 1, r - (length / 2), c);
        }
        else { //우측 하단
            count += mid * mid * 3;
            z(n - 1, r - (length / 2), c - (length / 2));
        }
    }
}