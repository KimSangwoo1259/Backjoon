import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());

        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++){
            arr[i] = Integer.valueOf(br.readLine());
        }
        Arrays.sort(arr);


        Set<Integer> sums = new HashSet<>();
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                sums.add(arr[i] + arr[j]);
            }
        }

        for (int i = n-1; i >= 0; i--){
            for (int j = 0; j < n; j++){
                if (sums.contains(arr[i] - arr[j])) {
                    System.out.println(arr[i]);
                    return;
                }
            }
        }
    }
}