import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        final int LEN = genres.length;
        Map<String, Integer> genreMap = new HashMap<>();
        List<Music> musicList = new ArrayList<>();
        for (int i = 0; i < LEN; i++) {
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
            musicList.add(new Music(genres[i], plays[i],i));
        }
        musicList.sort(Comparator.comparingInt((Music a) -> a.plays).reversed());

        // genre 순으로 key값
        List<String> genreKeys = genreMap.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        int genreLen = genreKeys.size();
        List<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < genreLen; i++) {
            int count = 0;
            String curGenre = genreKeys.get(i);
            for(int j = 0; j < LEN; j++){
                if (musicList.get(j).genre.equals(curGenre)){
                    count++;
                    answerList.add(musicList.get(j).pos);
                }
                if (count == 2){
                    break;
                }
            }
        }
       return answerList.stream().mapToInt(i -> i).toArray();


    }
    static class Music {
        String genre;
        int plays;
        int pos;
        public Music(String genre, int plays, int pos) {
            this.genre = genre;
            this.plays = plays;
            this.pos = pos;
        }
    }
}