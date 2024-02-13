import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.valueOf(st.nextToken());
        int b = Integer.valueOf(st.nextToken());
        boolean[] visited =new boolean[b + 1];
        int ans = 1000000000;
        Queue<Num> q = new LinkedList<>();
        q.add(new Num(a, 1));
        visited[(int) a] = true;
        while (!q.isEmpty()){
            Num now = q.poll();
            if (now.value * 2 == b || now.value*10 + 1 == b){
                ans = Math.min(ans, now.times + 1);
                continue;
            }
            if (now.value * 2 < b){
                if (!visited[(int) (now.value * 2)]){
                    q.add(new Num(now.value * 2, now.times + 1));
                    visited[(int) (now.value * 2)] = true;
                }
                if (now.value * 10 + 1 < b){
                    if (!visited[(int) (now.value * 10 + 1)]){
                        q.add(new Num(now.value * 10 + 1, now.times + 1));
                        visited[(int) (now.value * 10 + 1)] = true;
                    }
                }
            }
        }
        if (ans == 1000000000)
            System.out.println(-1);
        else
            System.out.println(ans);
    }
    static class Num {
        long value;
        int times;
        Num(long v, int t){
            value = v;
            times = t;
        }
    }
}