import java.util.*;
class Solution {
    public int[] solution(String msg) {
        List<Integer> list = new ArrayList<>();
        int num = 27;
        Map<String, Integer> map = new HashMap<>();
        int index = 0;
        StringBuilder sb= new StringBuilder();
        while(index < msg.length()) {
            if (sb.length() == 0) {
                sb.append(msg.charAt(index));
            }
            else{
                String temp = sb.toString() + msg.charAt(index);
                if (map.containsKey(temp)) {
                    sb.append(msg.charAt(index));
                }
                else {
                    if(sb.length() == 1){
                        int a = sb.charAt(0) - 'A' + 1;
                        list.add(a);
                    }
                    else{
                        list.add(map.get(sb.toString()));
                    }
                    map.put(temp, num);
                    num++;
                    sb.setLength(0);
                    sb.append(msg.charAt(index));
                }
            }

            index++;
        }
        if (sb.length() == 1) {
            list.add(sb.charAt(0) - 'A' + 1);
        }
        else{
            list.add(map.get(sb.toString()));
        }

        return list.stream().mapToInt(i -> i).toArray();
    }   
}