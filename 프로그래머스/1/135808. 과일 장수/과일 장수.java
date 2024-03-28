import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer  = 0;
        Arrays.sort(score);
        final int LEN = score.length;
        for (int i = LEN - m; i >= 0; i -= m){
            answer += (score[i]) * m;
        }
        return answer;
    }
}