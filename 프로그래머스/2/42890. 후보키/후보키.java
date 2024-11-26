import java.util.*;

class Solution {
   public static int solution(String[][] relation) {
        int answer = 0;

        Set<String> keySet = new HashSet<>();

        int row = relation.length;
        int column = relation[0].length;
        List<String> a = new ArrayList<>();
        List<String> b = new ArrayList<>();

        Queue<String> queue = new LinkedList<>();

        for (int i = 0; i < column; i++) {
            queue.offer(String.valueOf(i));
        }
        while (!queue.isEmpty()) {
            Map<List<String>, Integer> map = new HashMap<>();
            String current = queue.poll();
            boolean duplicate = false;
            boolean contain = false;

            for(String key : keySet){
                contain = true;
                int len = key.length();
                for(int i = 0; i < len; i++){
                    if (!current.contains(String.valueOf(key.charAt(i)))) {
                        contain = false;
                        break;
                    }
                }
                if(contain){
                    break;
                }
            }
            if (contain && current.length() > 1) // 최소 조건만족 안해서 후보키가 안됨
                continue;
            for(int i = 0; i < row; i++){
                List<String> temp = new ArrayList<>();
                for(int j = 0; j < current.length(); j++){
                    temp.add(relation[i][Character.getNumericValue(current.charAt(j))]);
                }
                if (map.containsKey(temp)) {
                    duplicate = true;
                    break;
                }
                map.put(temp,1);
            }
            if(!duplicate){
                keySet.add(current);
                answer++;
            }
            int last = Character.getNumericValue(current.charAt(current.length() - 1));
            for(int i = last+1; i < column; i++){
                queue.offer(current + i);
            }

        }

        return answer;
    }
}