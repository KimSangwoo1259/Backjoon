import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int f = Integer.valueOf(st.nextToken()); // 총 층수
        int s = Integer.valueOf(st.nextToken()); // 시작 층수
        int g = Integer.valueOf(st.nextToken()); // 목표 층수
        int u = Integer.valueOf(st.nextToken()); // 위
        int d = Integer.valueOf(st.nextToken()); // 아래
        if (s == g){
            System.out.println(0);
            return;
        }
        Queue<Ele> q = new LinkedList<>();
        int ans = 100000000;
        boolean[] visited = new boolean[f + 1];
        q.add(new Ele(s, 0));
        visited[s] = true;
        while (!q.isEmpty()){
            Ele now = q.poll();
            if (now.floor + u == g || now.floor - d == g){
                ans = Math.min(ans, now.times + 1);
            }
            if (now.floor + u <= f){
                if (!visited[now.floor + u]){
                    q.add(new Ele(now.floor + u, now.times + 1));
                    visited[now.floor + u] = true;
                }
            }
            if (now.floor - d >= 1){
                if (!visited[now.floor - d]){
                    q.add(new Ele(now.floor - d, now.times + 1));
                    visited[now.floor - d] = true;
                }
            }
        }
        if (ans == 100000000)
            System.out.println("use the stairs");
        else
            System.out.println(ans);




    }
    static class Ele{
        int floor;
        int times;
        Ele(int f, int t){
            floor = f;
            times = t;
        }
    }
}
