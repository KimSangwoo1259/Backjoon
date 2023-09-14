import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.valueOf(br.readLine());

        for (long i = 0; i < n; i++) {
            long num = Long.valueOf(br.readLine());
            if (num == 0 || num == 1) {
                bw.write(2 + "\n");
            }
            else {
                for (long j = num; ; j++) {
                    boolean isPrime = true;
                    for (long k = 2; k * k <= j; k++) {
                        if (j % k == 0) {
                            isPrime = false;
                            break;
                        }
                    }
                    if (isPrime) {
                        bw.write(j + "\n");
                        break;
                    }
                }
            }

        }
        bw.flush();
        bw.close();
    }

}