import java.util.*;


class Solution {
     public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> map = new HashMap<>();

        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }

        Set<String> keySet = map.keySet();

        for (String key : keySet) {
            answer *= (map.get(key) + 1);
        }
        answer--;


        return answer;
    }
}