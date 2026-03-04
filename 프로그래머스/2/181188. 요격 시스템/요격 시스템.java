import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        final int SIZE = targets.length;
        int[][] temp = new int[SIZE][2];

        for (int i = 0; i < SIZE; i++) {
            temp[i] = targets[i].clone();
        }
        Arrays.sort(temp, ((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        })); // 2차원 배열 정렬

        answer++;
        int left = temp[0][0];
        int right = temp[0][1];
        for (int i = 1; i < SIZE; i++){
            int newLeft = temp[i][0];
            int newRight = temp[i][1];
            
            if (right <= newLeft){
                answer++;
                left = newLeft;
                right = newRight;
            }
            else {
                left = Math.max(left, newLeft);
                right = Math.min(right, newRight);
            }
        }
        return answer;
    }
}