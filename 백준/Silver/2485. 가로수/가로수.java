import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        int[] trees = new int[n];
        int[] diff = new int[n - 1];
        for (int i = 0; i < n; i++){
            trees[i] = Integer.valueOf(br.readLine());
        }
        for (int i = 0 ; i < n -1; i++){
            diff[i] = trees[i + 1] - trees[i];
        }
        int gcd = gcd(diff[0], diff[1]);
        for (int i = 2; i < n -1; i++){
            gcd = gcd(gcd,diff[i]);
        }
        int count = 0;
        for (int i = 0; i < n-1; i++){
            count += (diff[i] / gcd - 1);
        }
        System.out.println(count);
    }

    public static int gcd (int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}