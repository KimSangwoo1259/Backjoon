import java.util.*;



class Solution {
     public int solution(String begin, String target, String[] words) {
        final int initValue = 1000000000;

        int answer = initValue;
        final int wordLen = begin.length();
        Queue<Word> q = new LinkedList<>();
        Set<String> wordSet = new HashSet<>();
        q.add(new Word(begin, 0));

        while(!q.isEmpty()) {
            Word w = q.poll();
            for(int i = 0; i < words.length; i++){
                String now = w.word;
                String validate = words[i];
                int count = 0;
                for (int j = 0; j < wordLen; j++) {
                    if(now.charAt(j) != validate.charAt(j)){
                        count++;
                    }
                    
                }
                if(count == 1 && !wordSet.contains(validate)){
                    if (validate.equals(target)){
                        answer = Math.min(w.level + 1, answer);
                    }
                    else {
                        wordSet.add(validate);
                        q.add(new Word(validate, w.level + 1));
                    }
                }
            }
        }
        if(answer == initValue){
            return 0;
        }
        return answer;
    }
    static class Word {
        String word;
        int level;

        public Word(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }
}