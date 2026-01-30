import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] ans = new int[n];

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= n; i++){
            q.offer(i);
        }

        for (int i = 0; i < n; i ++){
            for (int j = 1; j < k; j++){
                q.offer(q.poll());
            }
            ans[i] = q.poll();
        }

        System.out.println("<" +Arrays.stream(ans)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", ")) + ">");
    }
}
