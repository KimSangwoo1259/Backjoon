import java.util.*;

class Solution {
 public String[] solution(String[] record) {
        
        Map<String,String> idMap = new HashMap<>();

        for(int i=0;i<record.length;i++){
            String[] words = record[i].split(" ");
            if (words[0].equals("Enter") || words[0].equals("Change")){
                idMap.put(words[1],words[2]);
            }
        }

        List<String> list = new ArrayList<>();

        for(int i=0;i<record.length;i++){
            String[] words = record[i].split(" ");
            String user = idMap.get(words[1]);

            if (words[0].equals("Enter")){
                list.add(user + "님이 들어왔습니다.");
            }

            else if (words[0].equals("Leave")){
                list.add(user + "님이 나갔습니다.");
            }
        }


        return list.stream().toArray(String[]::new);
    }
}