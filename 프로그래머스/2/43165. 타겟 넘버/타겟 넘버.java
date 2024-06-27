import java.util.*;


class Solution {
    public int solution(int[] numbers, int target) {
        final int LEN = numbers.length;

        int answer = 0;
        Queue<Num> q = new LinkedList<>();
        q.add(new Num(numbers[0], 0));
        q.add(new Num(-numbers[0], 0));

        while(!q.isEmpty()){
            Num now = q.poll();
            if (now.level == LEN - 1){
                if (now.value == target)
                    answer++;
            }
            
            
            
            else{
                q.add(new Num(now.value + numbers[now.level + 1], now.level + 1));
                q.add(new Num(now.value - numbers[now.level + 1], now.level + 1));
            }
        }

        return answer;
    }
    static class Num{
        int value;
        int level;
        public Num(int value, int level) {
            this.value = value;
            this.level = level;
        }
    }
}