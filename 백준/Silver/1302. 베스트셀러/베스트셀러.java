import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        String temp;
        String answer = "";
        for (int i = 0; i < n; i++) {
            temp = br.readLine();
            if (!map.containsKey(temp)) {
                map.put(temp, 1);
            } else {
                map.put(temp, map.get(temp) + 1);
            }
        }
        Integer maxValue = Collections.max(map.values());

        ArrayList<String> al = new ArrayList<String>(map.keySet());
        Collections.sort(al);

        for (String s : al) {
            if(map.get(s) == maxValue) {
                answer = s;
                break;
            }
        }

        System.out.println(answer);

    }
}