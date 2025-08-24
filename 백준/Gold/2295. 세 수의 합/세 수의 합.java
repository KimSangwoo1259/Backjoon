import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        Set<Integer> sumSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());

        }
          Arrays.sort(arr);
        for (int i = 0; i< n; i ++){
            for (int j = 0; j < n; j++){
                sumSet.add(arr[i] + arr[j]);
            }
        }

        boolean found = false;
        // x + y + z = k == x + y = k - z
        for (int i = n - 1; i >= 0; i--){
            for (int j = 0; j < n; j++){
                if (sumSet.contains(arr[i] - arr[j])){
                    answer = arr[i];
                    found = true;
                    break;
                }

            }
            if (found)
                break;
        }

        System.out.println(answer);
    }
}