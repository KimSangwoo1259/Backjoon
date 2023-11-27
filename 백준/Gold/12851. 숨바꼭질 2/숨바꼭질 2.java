import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int k;

    static int[] visited;
    static int count[];
    static int[] preCount;
    static int depth;
    static int catchTime = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.valueOf(st.nextToken());
        k = Integer.valueOf(st.nextToken());

        preCount = new int[100001];
        visited = new int[100001];
        count = new int[100001];
        visited[n] = 1;
        count[n] = 1;
        preCount = count;
        Queue<Integer> q = new LinkedList<>();
        depth = 1;
        q.add(n);
        if (n == k) {
            System.out.println(0 + "\n" + 1);
        } else {
            while (!q.isEmpty()) {
                int now = q.poll();
                if (depth + 1 == visited[now]) {
                    preCount = count;
                    depth++;
                }
                if (visited[now] > catchTime) {
                    System.out.println(catchTime + "\n" + count[k]);
                    break;
                }
                int[] next = {now - 1, now + 1, 2 * now};
                for (int i = 0; i < 3; i++) {
                    if (next[i] < 0 || next[i] > 100000)
                        continue;
                    else {
                        if (visited[next[i]] == 0) {
                            q.add(next[i]);
                            visited[next[i]] = visited[now] + 1;
                        }
                        if (next[i] == k) {
                            if (catchTime == 1000000)
                                catchTime = visited[now];
                        }
                        if (next[i] == 18) {
                        }
                        if (visited[next[i]] == visited[now] + 1)
                            count[next[i]] += preCount[now];
                    }
                }


            }
        }
    }
}