import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.valueOf(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) == Math.abs(o2)) {
                return (o1 < o2) ? -1 : 1;
            }
            return Math.abs(o1) < Math.abs(o2) ? -1 : 1;
        });
        while (n --> 0){
            int x = Integer.valueOf(br.readLine());
            if (x == 0){
                if (pq.isEmpty())
                    bw.write(0 + "\n");
                else
                    bw.write(pq.poll() + "\n");
            }
            else {
                pq.add(x);
            }

        }
        bw.flush();
        bw.close();
    }
}