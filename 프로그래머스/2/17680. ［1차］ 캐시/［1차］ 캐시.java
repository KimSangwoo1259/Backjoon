import java.util.*;


class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if (cacheSize == 0)
            return cities.length * 5;
        Deque<String> deque = new ArrayDeque<>();
        String[] newCities = new String[cities.length];
        for (int i = 0; i < cities.length; i++){
            newCities[i] = cities[i].toUpperCase(Locale.ROOT);
        }
        for (int i = 0; i < cities.length; i++){// cache hit
            if (deque.contains(newCities[i])){
                deque.remove(newCities[i]);
                deque.addFirst(newCities[i]);
                answer++;
            }
            else { // cache miss
                if (deque.size() == cacheSize){
                    deque.removeLast();
                    deque.addFirst(newCities[i]);
                }
                else {
                    deque.addFirst(newCities[i]);
                }
                answer += 5;
            }
        }
        return answer;
    }
}
