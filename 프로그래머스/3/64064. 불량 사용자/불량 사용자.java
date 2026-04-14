import java.util.HashSet;
import java.util.Set;

class Solution {
    String[] ids;
    String[] bans;
    boolean[] banned;
    int answer;
    Set<String> set;
    public int solution(String[] user_id, String[] banned_id) {
        ids = user_id;
        bans = banned_id;
        banned = new boolean[user_id.length];
        answer = 0;
        set = new HashSet<>();
        recursion(0);
        return answer;
    }
    public void recursion( int index){
        if (index == bans.length) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < banned.length; i++){
                if (banned[i])
                    sb.append(i);
            }
            String indexes = sb.toString();
            if (!set.contains(indexes)) {
                set.add(indexes);
                answer++;
            }

            return;
        }
        String compare = bans[index];
        for (int i = 0; i < ids.length; i++){
            if (banned[i])
                continue;
            if (isMatch(ids[i],compare)){
                banned[i] = true;
                recursion(index+1);
                banned[i] = false;
            }
        }

    }
    public boolean isMatch(String target, String compare){
        if (target.length()!= compare.length())
            return false;
        if (target.equals(compare))
            return true;

        for (int i = 0; i < target.length(); i++){
            char t = target.charAt(i);
            char c =  compare.charAt(i);

            if (c == '*')
                continue;
            if (t != c)
                return false;
        }
        return true;


    }



}
