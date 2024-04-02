import java.util.*;
class Solution {
    public static int solution(String[] babbling) {
        int answer = 0;
        final int LEN = babbling.length;
        String[] canSpeak = {"aya", "ye", "woo", "ma"};
        Set<String> wordSet = new HashSet<>();

        Queue<Word> q = new LinkedList<>();
        
        for (int i = 0; i <4; i++){
            q.add(new Word(canSpeak[i], canSpeak[i]));
        }
        while (!q.isEmpty()){
            Word now = q.poll();
            wordSet.add(now.word);
            for (int i = 0; i < 4; i++){
                if (canSpeak[i] != now.prev && (now.word + canSpeak[i]).length() <= 30){
                    q.add(new Word(canSpeak[i], now.word + canSpeak[i]));
                }
            }
        }
        for (int i = 0; i < LEN; i++){
            if (wordSet.contains(babbling[i]))
                answer++;
        }

        return answer;
    }
    
    static class Word {
        String prev;
        String word;

        public Word(String prev, String word) {
            this.prev = prev;
            this.word = word;
        }
    }
}