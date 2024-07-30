import java.util.*;


class Solution {
   public int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for (int i : queue1){
            q1.offer(i);
        }
        for (int i : queue2){
            q2.offer(i);
        }

         int maxCount = (queue1.length + queue2.length) * 2;
        long sum1 = q1.stream().mapToLong(Integer::longValue).sum();
        long sum2 = q2.stream().mapToLong(Integer::longValue).sum();

        if ((sum1 + sum2) % 2 != 0)
            return -1;

        while(sum1 != sum2 && answer <= maxCount){
            if (sum1 > sum2){
                int temp = q1.poll();
                q2.offer(temp);
                sum1 -= temp;
                sum2 += temp;
                answer++;
            }
            else {
                int temp = q2.poll();
                q1.offer(temp);
                sum1 += temp;
                sum2 -= temp;
                answer++;
            }
        }
        
        if (answer > maxCount)
            return -1;
        return answer;
    }
}