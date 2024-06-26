import java.util.*;

class Solution {
   public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        int[] count = new int[n];
        Set<String> spokeWords = new HashSet<>();
        String beforeWord = words[0];
        count[0]++;
spokeWords.add(beforeWord);

        for (int i = 1; i < words.length; i++) {
            if (!spokeWords.contains(words[i]) && beforeWord.charAt(beforeWord.length() - 1) == words[i].charAt(0)) {
                spokeWords.add(words[i]);
                count[i%n]++;
                beforeWord = words[i];
            }
            else{
                answer[0] = i % n + 1;
                count[i%n]++;
                answer[1] = count[i % n];
                 break;
            }
        }

        return answer;
    }
}