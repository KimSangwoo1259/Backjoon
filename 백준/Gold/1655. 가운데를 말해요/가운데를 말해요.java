import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    // 가운데값을 기준으로 가운데 값 보다 작은 최대힙, 가운대 값 보다 큰 최소힙 2개를 생성해서 관리
    // 짝수일때, 홀 수 일때가 다름.
    // 홀수일때.
    // 중간 값보다 작거나 같은 경우, 최대힙에 넣기
    // 중간값 보다 큰경우, mid 값을 최대힙에 넣고
    // 짝수일 때 -> 중간값보다 작은 최대힙의 개수가 최소힙의 사이즈보다 1 작아야함.
    // 만약 들어온 값이 mid보다 크거나 같은 경우 -> 그냥 최소힙에 넣기
    // 작은 경우. 원래 mid 값을 최소힙에 넣고 들어온 값을 최대 힙에 넣고 mid 값을 최소 힙에서 poll
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeapBiggerThanMid = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeapSmallerThanMid = new PriorityQueue<>(Comparator.reverseOrder());

        int mid = Integer.parseInt(br.readLine());;

        sb.append(mid).append("\n");

        for (int i = 2; i<= n; i++){
            int value = Integer.parseInt(br.readLine());
            if (i % 2 == 1){ // 홀수 일때
                if (mid >= value){
                    maxHeapSmallerThanMid.offer(value);
                }
                else {
                    maxHeapSmallerThanMid.offer(mid);
                    minHeapBiggerThanMid.offer(value);
                    mid = minHeapBiggerThanMid.poll();
                }
            }
            else { //짝수일때
                if (mid <= value){
                    minHeapBiggerThanMid.offer(value);
                }
                else {
                    minHeapBiggerThanMid.offer(mid);
                    maxHeapSmallerThanMid.offer(value);

                    mid = maxHeapSmallerThanMid.poll();
                }
            }
            sb.append(mid).append("\n");
        }
        System.out.println(sb);
        //   1 3 6 8 10


    }
}

