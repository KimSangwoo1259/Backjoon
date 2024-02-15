import java.io.*;

public class Main {
    static int n;
    static int[] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        n = Integer.valueOf(br.readLine());
        arr = new int[n];
        findPrime(0);
        System.out.println(sb);


    }
    static void findPrime(int num){
        if (num == n){
            int temp = 0;
            for (int i = 0; i < n; i++){
                temp += arr[i] * Math.pow(10, n - 1 - i);
            }
            sb.append(temp + "\n");
            return;
        }
        for (int i = 1; i <= 9; i++){
            if (num == 0){
                if (isPrime(i) == true){
                    arr[num] = i;
                    findPrime(num + 1);
                }
            }
            else {
                int temp = 0;
                for (int j = 0; j < num; j++){
                    temp += arr[j] * Math.pow(10, num - 1 - j);
                }
                temp = temp * 10 + i;
                if (isPrime(temp)){
                    arr[num] = i;
                    findPrime(num + 1);
                }
            }
        }
    }
    static boolean isPrime(int num){
        if (num == 1)
            return false;
        for (int i = 2; i <= Math.sqrt(num); i++){
            if (num % i == 0)
                return false;
        }
        return true;
    }

}
