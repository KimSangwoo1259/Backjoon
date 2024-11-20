import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        PriorityQueue<Num> pq = new PriorityQueue<>();
        for (int number : numbers) {
            pq.add(new Num(number));
        }
        while (!pq.isEmpty()) {
            Num num = pq.poll();
            answer.append(num.value);
        }

        if (answer.charAt(0) == '0')
            return "0";

        return answer.toString();
    }
    static class Num implements Comparable<Num> {
        String value;
        public Num(int value) {
            this.value = String.valueOf(value);
        }

        @Override
        public int compareTo(Num o) {
           return Integer.parseInt(o.value+this.value) - Integer.parseInt(this.value+o.value);
        }
    }
}