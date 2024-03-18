import java.util.*;


class Solution {
    public int solution(int storey) {
        int answer = 100000000;
        String temp = String.valueOf(storey);
        final int LEN = temp.length();

        Queue<Num> q = new LinkedList<>();

        q.add(new Num(storey, 0, 0));
        while (!q.isEmpty()){
            Num now = q.poll();
            String str = String.valueOf(now.value);
            int n = Character.getNumericValue(str.charAt(LEN - 1 - now.level));
            if (now.level == LEN - 1 ){
                int candidate = now.times;
                if (n <= 5){
                    candidate += n;
                }
                else {
                    candidate += (10 - n) + 1;
                }
                answer = Math.min(answer, candidate);
            }
            else {
                int num1 = now.value - n * (int) Math.pow(10, now.level);
                int num2 = now.value + (10 - n) * (int) Math.pow(10, now.level);
                q.add(new Num(num1, now.level + 1, now.times + n));
                q.add(new Num(num2, now.level + 1, now.times + (10 - n)));
            }
        }

        return answer;
    }
    static class Num {
        int value, level,times;
        Num(int v, int l, int t){
            value = v;
            level = l;
            times = t;
        }
    }
}