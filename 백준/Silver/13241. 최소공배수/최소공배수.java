import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Integer.valueOf(st.nextToken());
        long b = Integer.valueOf(st.nextToken());


        long gcd = calGcd(a, b);

        System.out.println(a * b / gcd);



    }
    public static long calGcd(long a, long b){
        if(b == 0) return a;
        return calGcd(b, a % b);
    }
}
