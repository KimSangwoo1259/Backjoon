import java.io.*;
import java.util.PriorityQueue;

public class Main {

    static class AbsoluteNumber implements Comparable<AbsoluteNumber>{
        int value;

        @Override
        public int compareTo(AbsoluteNumber other) {
            int t = Math.abs(this.value);
            int o = Math.abs(other.value);
            if (t == o)
                return this.value > other.value ? 1 : -1;
            return t - o;
        }

        public AbsoluteNumber(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        PriorityQueue<AbsoluteNumber> pq = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());

            if (num == 0){
                if (pq.isEmpty())
                    sb.append(0);

                else
                    sb.append(pq.poll().value);
                sb.append("\n");
            }
            else {
                pq.add(new AbsoluteNumber(num));
            }
        }

        System.out.println(sb);

     }

}
