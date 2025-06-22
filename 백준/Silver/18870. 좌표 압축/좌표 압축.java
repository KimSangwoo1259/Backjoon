
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int line = Integer.valueOf(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> numSet = new TreeSet<>();
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < line; i++){
            int v = Integer.parseInt(st.nextToken());
            numSet.add(v);
            numList.add(v);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int value = 0;
        for (Integer temp : numSet){
            map.put(temp, value);
            value++;
        }

        StringBuilder sb = new StringBuilder();
        for (Integer temp : numList){
            sb.append(map.get(temp)).append(" ");
        }

        System.out.println(sb);






    }
}
