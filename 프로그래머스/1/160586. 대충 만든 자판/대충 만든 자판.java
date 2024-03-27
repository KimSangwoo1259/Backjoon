import java.util.*;


class Solution {
   public int[] solution(String[] keymap, String[] targets) {
        int[] alphaCount = new int[26];
        int[] answer = new int[targets.length];
        for (int i = 0; i < keymap.length; i++){
            for (int j = 0; j < keymap[i].length(); j++){
                int index = keymap[i].charAt(j) - 'A';
                if (alphaCount[index] == 0)
                    alphaCount[index] = j + 1;
                else{
                    if (alphaCount[index] > j + 1)
                        alphaCount[index] = j + 1;
                }
            }
        }
        for (int i = 0; i < targets.length; i++){
            for (int j = 0; j < targets[i].length(); j++){
                int click = alphaCount[targets[i].charAt(j) - 'A'];
                if (click == 0){
                    answer[i] = -1;
                    break;
                }
                else 
                    answer[i] += click;
            }
        }
        return answer;
    }
}