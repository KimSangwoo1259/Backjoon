
import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        char prevLastChar = words[0].charAt(words[0].length() - 1);
        int[] answer = new int[2]; // [번호, 차례]

        int index = -1;
        Set<String> usedWords = new HashSet<>();

        usedWords.add(words[0]);

        for (int i = 1; i < words.length; i++){
            String now = words[i];

            if (usedWords.contains(now) || prevLastChar != now.charAt(0)){
                index = i;
                break;
            }

            usedWords.add(now);
            prevLastChar = now.charAt(now.length() - 1);
        }

        if (index == -1){
            return answer;
        }



        // 번호 -> index % 3 + 1
        // 몇 번째? index / 3 + 1

        answer[0] = index % n + 1;
        answer[1] = index / n + 1;

        return answer;
    }
}
// 이미 사용된 단어 X
// 바로 전 거랑 앞거랑 이어져야함
