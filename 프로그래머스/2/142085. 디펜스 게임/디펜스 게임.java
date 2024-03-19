import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        final int LEN = enemy.length;
        int sum = 0;
        int remainK = k;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // 최대 힙

        for (int i = 0; i < LEN; i++){
            pq.add(enemy[i]);
            if (sum + enemy[i] > n){
                if (remainK == 0){
                    return i;
                }
                else {
                    remainK--;
                    sum += enemy[i];
                    sum -= pq.peek();
                    pq.poll();
                }
            }
            else {
                sum += enemy[i];
            }
        }

        return LEN; // return 문이 실행되지 않았으므로 끝까지 간것
    }
}