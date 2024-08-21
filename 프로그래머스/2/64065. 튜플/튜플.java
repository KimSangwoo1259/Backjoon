import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer;
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Set<Character> charSet = new HashSet<>();
        charSet.add('{');
        charSet.add('}');
        charSet.add(',');
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9) {
                sb.append(s.charAt(i));
            }
            else {
                if (sb.length() > 0) {
                    int key = Integer.parseInt(sb.toString());
                    map.put(key, map.getOrDefault(key, 0) + 1);
                    sb.setLength(0);
                }

            }
        }
        Set<Integer> integers = map.keySet();
        answer = new int[integers.size()];
        for (Integer key : integers) {
            answer[integers.size() - map.get(key)] = key;
        }


        return answer;
    }
}// 4 -> 0 3 -> 1 2 ->2 1 -> 3