import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < enemy.length;i ++){
            int nowEnemy = enemy[i];
            n -= nowEnemy;
            pq.add(nowEnemy);
            if (n< 0){
                while(!pq.isEmpty() && n < 0 && k > 0){
                    int top = pq.poll();
                    n += top;
                    k--;
                }
            }
            if (n < 0){
                answer = i;
                break;
            }
        }
        if (n >= 0){
            answer = enemy.length;
        }

        return answer;
    }
}