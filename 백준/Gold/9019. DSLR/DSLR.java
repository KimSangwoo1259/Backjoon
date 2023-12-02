import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static BufferedWriter bw;
    static int from;
    static int to;
    static Queue<Num> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.valueOf(br.readLine());
        bw = new BufferedWriter(new OutputStreamWriter(System.out));



        StringTokenizer st;
        while(t --> 0){
            st = new StringTokenizer(br.readLine());
            q = new LinkedList<>();
            from = Integer.valueOf(st.nextToken());
            to = Integer.valueOf(st.nextToken());
            visited = new boolean[10000];
            q.add(new Num(from, new StringBuilder()));
            visited[from] = true;
            char[] cmd = {'D', 'S', 'L', 'R'};

            while (!q.isEmpty()){
                Num now = q.poll();
                if (now.value == to){
                    bw.write(now.sb + "\n");
                    break;
                }
                int[] next = {d(now.value), s(now.value), l(now.value), r(now.value)};
                for (int i = 0; i < 4; i++){
                    if (!visited[next[i]]){
                        visited[next[i]] = true;
                        q.add(new Num(next[i], new StringBuilder(now.sb).append(cmd[i])));
                    }
                }
            }
        }
        bw.flush();
        bw.close();
    }
    static class Num{
        int value;
        StringBuilder sb;

        Num(int v, StringBuilder s){
            this.value = v;
            this.sb = s;
        }
    }
    static int d(int n){
        return (n * 2) % 10000;
    }
    static int s(int n){
        if (n == 0)
            return 9999;
        return n - 1;
    }
    static int l(int n){
        return (n % 1000) * 10 + n / 1000;


    }
    static int r(int n){
        return (n % 10) * 1000 + n / 10;
    }
}