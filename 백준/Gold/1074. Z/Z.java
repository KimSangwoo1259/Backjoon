import java.io.*;
import java.util.StringTokenizer;

public class Main {


    static int n;
    static int r;
    static int c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int ans = z(n,r,c);

        System.out.println(ans);
    }
    static int z(int a, int b, int c){
        if (a == 1){
            return 2 * b + c;
        }
        int len = (int) Math.pow(2, a);
        int temp = 0;
        if (b >= len / 2){
            b -= (len / 2);
            temp += len * len / 2;
        }
        if (c >= len / 2){
            c -= (len / 2);
            temp += len * len / 4;
        }
        return temp + z(a - 1, b, c);
    }

}
