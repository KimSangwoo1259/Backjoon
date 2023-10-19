import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());
        int c = Integer.valueOf(st.nextToken());
        int preValue;
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> orderMap = new HashMap<>();
        Integer[] arr = new Integer[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++){
            arr[i] = Integer.valueOf(st.nextToken());
            if (map.containsKey(arr[i]))
                map.put(arr[i], map.get(arr[i]) + 1);
            else
                map.put(arr[i], 1);
        }
        orderMap.put(arr[0], 1);
        preValue = arr[0];
        for (int i = 1; i < n; i++){
            if (!orderMap.containsKey(arr[i])) {
                orderMap.put(arr[i], orderMap.get(preValue)+1);
                preValue = arr[i];
            }
        }
        Arrays.sort(arr,(o1, o2) -> {
                if (map.get(o1) == map.get(o2))
                    return orderMap.get(o1) - orderMap.get(o2);
                else
                    return map.get(o2) - map.get(o1);

        } );

        for (int i = 0; i < n; i++){
            bw.write(arr[i] + " ");
        }

        bw.flush();
        bw.close();
    }
}