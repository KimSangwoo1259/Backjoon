import java.util.Comparator;
import java.util.PriorityQueue;
class Solution {
    public int solution(int[] cards) {
         int answer = 0;
        final int LEN = cards.length;
        boolean[] open = new boolean[LEN];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        for (int i = 0; i < LEN; i++) {
            int score = 0;
            int index = i;
            if (!open[index]){
                while (true){
                    score++;
                    open[index] = true;
                    index = cards[index] - 1;
                    if (open[index])
                        break;
                }
                pq.add(score);
            }
        }
        if (pq.size() == 1)
            return 0;
        answer = pq.poll() * pq.poll();

        return answer;
    }
}