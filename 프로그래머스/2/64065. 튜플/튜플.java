import java.util.*;


class Solution {
    public int[] solution(String s) {

        Map<Integer, Integer> countMap = new HashMap<>();

        s =s.replace("{", "");
        s = s.replace("}", "");
        String[] split = s.split(",");

        for (String string : split) {
            Integer key = Integer.valueOf(string);

            countMap.put(key, countMap.getOrDefault(key, 0) + 1);
        }
        List<Integer> keyList = new ArrayList<>(countMap.keySet());

        keyList.sort((k1,k2) -> countMap.get(k2) - countMap.get(k1));

        int size = keyList.size();
        int[] answer = new int[size];

        for (int i = 0; i < size; i++){
            answer[i] = keyList.get(i);
        }
        return answer;
    }
}