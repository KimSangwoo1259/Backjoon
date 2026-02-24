import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    // 0 1 3 5
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());


        while(t--> 0){
            int n = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> minHeapBiggerThanMid = new PriorityQueue<>();
            PriorityQueue<Integer> maxheapSmallerThanMid = new PriorityQueue<>(Comparator.reverseOrder());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int quantity = (n % 2 == 0) ? n / 2 : n / 2 + 1;
            sb.append(quantity).append("\n");
            int count = 1;
            int mid = Integer.parseInt(st.nextToken());
            sb.append(mid).append(" ");
            // 만약 지금 들어온 값이 mid 보다 크거나 같다.
            // 짝수일때 그냥 minHeap 에 넣어주기
            // 홀수일때 들어온거 minHeap 에 넣고 기존 mid maxHeap에 넣고 mid 는 minHeap 에서 poll 한거
            // 만약 지금 들어온 값이 mid 보다 작다.
            // 짝수일때 들어온거 maxHeap에 넣고 기존 mid minHeap 넣고 mid 는 maxHeap 에서 poll 한거
            // 홀수일때 그냥 들어온거 maxHeap에 넣어주기
            for (int i = 2; i <=n; i++){
                if (i % 10 == 1){
                    st = new StringTokenizer(br.readLine());
                }
                int cur = Integer.parseInt(st.nextToken());
                if (i % 2 == 0){
                    if (cur >= mid)
                        minHeapBiggerThanMid.offer(cur);
                    else {
                        maxheapSmallerThanMid.offer(cur);
                        minHeapBiggerThanMid.offer(mid);
                        mid = maxheapSmallerThanMid.poll();
                    }
                }
                else {
                    count++;
                    if (cur >= mid){
                        minHeapBiggerThanMid.offer(cur);
                        maxheapSmallerThanMid.offer(mid);
                        mid = minHeapBiggerThanMid.poll();
                    }
                    else {
                        maxheapSmallerThanMid.offer(cur);
                    }
                    sb.append(mid).append(" ");
                    if (count == 10){
                        sb.append("\n");
                        count = 0;
                    }

                }
            }
            if (count != 0)
                sb.append("\n");

        }

        System.out.println(sb);
    }


}

