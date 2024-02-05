import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int LENGTH = 101;

        boolean[] visited = new boolean[LENGTH];
        int answer = 1000000000;
        boolean founded = false;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n + m; i++){
            st = new StringTokenizer(br.readLine());
            int key = Integer.valueOf(st.nextToken());
            int value = Integer.valueOf(st.nextToken());
            map.put(key, value);
        }
        visited[1] = true;
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(1, 0));

        while (!q.isEmpty()){
            Pos now = q.poll();
            for (int i = 1; i <= 6; i++){
                Integer temp = now.position + i;
                while (true){
                    if (map.containsKey(temp))
                        temp = map.get(temp);
                    else
                        break;
                }
                if (!visited[temp]) {
                    if (temp == 100){
                        answer = Math.min(answer, now.times + 1);
                        break;
                    }
                    q.offer(new Pos(temp, now.times + 1));
                    visited[temp] = true;
                }
            }
        }
        System.out.println(answer);
    }
    static class Pos{
        int position,times;
        Pos(int p, int t){
            position = p;
            times = t;
        }
    }
}