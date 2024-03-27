import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] position = new int[26];
        Arrays.fill(position,-1);

        for (int i = 0; i < s.length(); i++){
            int temp = s.charAt(i) - 'a';
            if (position[temp] == -1)
                answer[i] = -1;
            else {
                answer[i] = i - position[temp];
            }
            position[temp] = i;
        }
        return answer;
    }
}