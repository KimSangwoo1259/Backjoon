import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.valueOf(br.readLine());

        List<Meeting> meeting = new ArrayList<>();

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            meeting.add(new Meeting(Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken())));
        }
        meeting.sort((o1, o2) -> {
            if (o1.start == o2.start) return o1.end - o2.end;
            return o1.start - o2.start;
        });

        PriorityQueue<Meeting> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.end));

        int ans = 1;


        for (int i = 0; i < n; i++){
            if (pq.isEmpty())
                pq.offer(meeting.get(i));
            else{
                Meeting temp = meeting.get(i);
                while (!pq.isEmpty()){
                    if (pq.peek().end > temp.start) break;
                    pq.poll();
                }
                pq.offer(temp);
                ans = Math.max(ans, pq.size());
            }
        }
        System.out.println(ans);

    }
}
class Meeting{
    int start;
    int end;

    Meeting(int s, int e){
        start = s;
        end = e;
    }
}