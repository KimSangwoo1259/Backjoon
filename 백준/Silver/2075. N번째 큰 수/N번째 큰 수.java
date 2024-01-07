import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        int n = Integer.valueOf(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int x;

        for (int i = 0; i < n; i++) {
            x = Integer.valueOf(st.nextToken());
            pq.add(x);
        }



        for (int i = 1; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                x = Integer.valueOf(st.nextToken());
                pq.add(x);
                pq.poll();
            }
        }
        System.out.println(pq.poll());

    }
}