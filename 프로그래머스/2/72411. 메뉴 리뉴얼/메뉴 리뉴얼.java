import java.util.*;


class Solution {
    static Map<String, Integer> map;
    static boolean[] visited = new boolean[10];
    static StringBuilder sb = new StringBuilder();
    static int len;
    static int max;
    public static String[] solution(String[] orders, int[] course) {
        List<String> list = new ArrayList<>();
        for (int c : course){
            map = new HashMap<>();
            max = 0;
            len = c;
            for(String order: orders) {
                backTrack(order, 0);
                sb.delete(0, sb.length());
            }
            if (max >= 2) {
                Set<String> keySet = map.keySet();
                for (String key : keySet) {
                    if (map.get(key) == max) {
                        list.add(key);
                    }
                }
            }
        }

        list.sort(String::compareTo);

        String[] answer = list.toArray(new String[list.size()]);
        return answer;
    }
    public static void backTrack(String str, int level){
        if (level == len){
            map.put(sb.toString(), map.getOrDefault(sb.toString(),0) + 1);
            max = Math.max(max,map.get(sb.toString()));
            return;
        }
        for (int i = 0; i < str.length(); i++){
            if(!visited[i]){
                if (sb.length() == 0){
                    visited[i] = true;
                    sb.append(str.charAt(i));
                    backTrack(str, level + 1);
                    visited[i] = false;
                    sb.deleteCharAt(sb.length()-1);
                }
                else{
                    if (str.charAt(i) > sb.charAt(sb.length()-1)){
                        visited[i] = true;
                        sb.append(str.charAt(i));
                        backTrack(str, level + 1);
                        visited[i] = false;
                        sb.deleteCharAt(sb.length()-1);
                    }
                }
            }

        }

    }
}   