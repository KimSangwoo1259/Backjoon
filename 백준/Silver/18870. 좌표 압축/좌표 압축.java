import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Integer n = Integer.valueOf(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        Integer[] arr = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n ; i++){
            arr[i] = Integer.valueOf(st.nextToken());
        }
        Integer[] copy = Arrays.copyOf(arr, n);
        Arrays.sort(copy);
        map.put(copy[0], 0);

        for (int i = 1; i < n; i++){
            if(!copy[i].equals(copy[i-1])) {
                map.put(copy[i], map.get(copy[i - 1]) + 1);
            }
        }
        for (int i = 0; i < n; i++){
            bw.write(map.get(arr[i]) + " ");

        }
        bw.flush();
        bw.close();

    }
}