import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int length = 250000;
        int[] primeCount = new int[length];
        boolean[] isPrime = new boolean[length];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i < length; i++){
            if(isPrime[i]){
                for (int j = i * i; j < length; j += i)
                    isPrime[j] = false;
            }
        }
        for (int i = 2; i < length; i++){
            primeCount[i] = primeCount[i-1];
            if (isPrime[i])
                primeCount[i]++;
        }
        while (true){
            int n = Integer.valueOf(br.readLine());
            if(n == 0)
                break;
            bw.write((primeCount[2 * n] - primeCount[n]) + "\n");
        }
        bw.flush();
        bw.close();
    }
}