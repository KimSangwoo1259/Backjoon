import java.util.*;


class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();

        List<Num> numList = new ArrayList<>();
        
        boolean onlyZero = true;
        for (int i = 0; i < numbers.length; i++){
            if (numbers[i] != 0)
                onlyZero = false;
            numList.add(new Num(String.valueOf(numbers[i])));
        }
        if (onlyZero)
            return "0";

        numList.sort((n1, n2) -> {
            int first = Integer.parseInt(n1.value + n2.value);
            int second = Integer.parseInt(n2.value + n1.value);

            return second - first;
        });

        for (int i = 0; i < numList.size(); i++){
            sb.append(numList.get(i).value);
        }
        



        return sb.toString();
    }
    class Num implements Comparable<Num>{
        String value;

        @Override
        public int compareTo(Num o) {
            int first = Integer.parseInt(this.value + o.value);
            int second = Integer.parseInt(o.value + this.value);

            return second - first;
        }

        public Num(String value) {
            this.value = value;
        }
    }
}