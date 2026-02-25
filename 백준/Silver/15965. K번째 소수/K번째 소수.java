import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int SIZE = 10000000;
        boolean[] isPrime = new boolean[SIZE];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        List<Integer> primeList = new ArrayList<>();

        for (int i = 2; i < SIZE; i++){
            if (isPrime[i]){
                primeList.add(i);
                for (int j = i * 2; j <SIZE; j += i){
                    isPrime[j] = false;
                }
            }
        }

        int k = Integer.parseInt(br.readLine());


        System.out.println(primeList.get(k-1));



    }

}
