import java.io.*;
import java.util.StringTokenizer;


public class Main {


   // (A*B) % C = ((A%C) * (B%C)) % C
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(power(a,b,c));

    }
    static long power(int a, int b, int c){
        boolean even = b % 2 == 0;
        if (b == 1){
            return a % c;
        }

        long half = power(a, b / 2, c);
        if (even){
            return (half * half) % c;
        }
        else {
            return (((half * half)% c )* a) % c;
        }

    }

}
