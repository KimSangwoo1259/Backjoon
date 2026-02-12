import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Room implements Comparable<Room>{
        int start;
        int end;
        @Override
        public int compareTo(Room o) {
            return this.end - o.end;
        }

        public Room(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Room[] arr = new Room[n];
        int ans = 1;
        PriorityQueue<Room> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[i] = new Room(start, end);
        }
        Arrays.sort(arr, ((o1, o2) -> {
            if (o1.start == o2.start) return o1.end - o2.end;
            return o1.start - o2.start;
        }));


        for (int i = 0; i <n; i++){
            Room now = arr[i];

            if (pq.isEmpty()){
                pq.add(now);
            }
            else {
                while(!pq.isEmpty() && pq.peek().end <= now.start){
                    pq.poll();
                }
                pq.add(now);
            }
            ans = Math.max(ans, pq.size());
        }

        System.out.println(ans);
    }
}

