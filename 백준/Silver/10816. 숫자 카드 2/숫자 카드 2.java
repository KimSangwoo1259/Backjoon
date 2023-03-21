import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main { // 이문제는 Scanner 를 사용해서 시간초과가 계속난 문제이다. 앞으로는 BufferReader와 StringTokenizer를 사용하자

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> map = new HashMap<>(); // Key와, Key의 개수를 저장하는 HashMap
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            int temp = Integer.parseInt(st.nextToken());
            Integer value = map.get(temp);
            if(value != null){
                map.put(temp, value + 1);
            }
            else{
                map.put(temp, 1);
            }
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            int temp = Integer.parseInt(st.nextToken());
            Integer value = map.get(temp);
            if(value != null)
                sb.append(value).append(" ");
            else
                sb.append(0).append(" ");
        }
        System.out.println(sb);
        
    }
}