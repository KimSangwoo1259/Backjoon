import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : scoville)
            pq.add(i);
        while(pq.size() > 1 && pq.peek() < K){
            int l1 = pq.poll();
            int l2 = pq.poll();
            pq.add(l1 + l2 * 2);
            answer++;
        }

        if (pq.peek() < K)
            return -1;

        return answer;
    }
}