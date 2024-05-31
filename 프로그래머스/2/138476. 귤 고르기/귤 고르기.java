import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Arrays.sort(tangerine);
        PriorityQueue<Tang> pq = new PriorityQueue<>();
        int count = 1;
        int curNum = tangerine[0];
        for (int i = 1; i < tangerine.length; i++) {
            if (curNum != tangerine[i]) {
                pq.add(new Tang(curNum, count));
                count = 1;
                curNum = tangerine[i];
            }
            else
                count++;
        }
        pq.add(new Tang(curNum, count));
        
        int ansCount = 0;
        while (ansCount < k){
            ansCount += pq.poll().quantity;
            answer++;
        }

        return answer;
    }
    static class Tang implements Comparable<Tang>{
        int size;
        int quantity;

        public Tang(int size, int quantity) {
            this.size = size;
            this.quantity = quantity;
        }

        @Override
        public int compareTo(Tang o) {
            if(this.quantity > o.quantity){
                return -1;
            }
            else if(this.quantity < o.quantity){
                return 1;
            }
            return 0;
        }
    }
}