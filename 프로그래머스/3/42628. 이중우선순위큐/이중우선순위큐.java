import java.util.*;


class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];

        PriorityQueue<Integer> pqASC = new PriorityQueue<>();
        PriorityQueue<Integer> pqDESC = new PriorityQueue<>(Comparator.reverseOrder());


        for (String operation : operations) {
            String[] s = operation.split(" ");

            if (s[0].equals("I")){
                pqASC.add(Integer.parseInt(s[1]));
                pqDESC.add(Integer.parseInt(s[1]));
            }
            else {
                if (!pqASC.isEmpty() && !pqDESC.isEmpty()) {
                    if (s[1].equals("1")) {
                        int value = pqDESC.poll();
                        pqASC.remove(value);
                    } else {
                        int value = pqASC.poll();
                        pqDESC.remove(value);
                    }
                }
            }
        }

        if (!pqASC.isEmpty() && !pqDESC.isEmpty()) {
            answer[0] = pqDESC.poll();
            answer[1] = pqASC.poll();
        }

        return answer;
    }
}