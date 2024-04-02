import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zeroCount = 0;
        Set<Integer> numSet = new HashSet<>();

        for (int i = 0; i < lottos.length; i++){
            if (lottos[i] != 0)
                numSet.add(lottos[i]);
            else
                zeroCount++;
        }
        int hitCount = 0;
        for (int i = 0; i < win_nums.length; i++){
            if (numSet.contains(win_nums[i]))
                hitCount++;
        }
        int minGrade = 7;
        minGrade -= hitCount;

        minGrade = (minGrade >= 6) ? 6 : minGrade;
        answer[1] = minGrade;
        minGrade -= zeroCount;
        minGrade = (minGrade < 1) ? 1 : minGrade;
        answer[0] = minGrade;

        return answer;
    }
}