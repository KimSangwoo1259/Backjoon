import java.util.*;


class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        

        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < skill.length(); i++){
            charSet.add(skill.charAt(i));
        }
        for (int i = 0; i < skill_trees.length; i++){
            boolean canLearn = true;
            int index = 0;
            for (int j = 0; j < skill_trees[i].length(); j++){
                char now = skill_trees[i].charAt(j);
                if(charSet.contains(now)){
                    if (now == skill.charAt(index))
                        index++;
                    else{
                        canLearn = false;
                        break;
                    }
                }
            }
            if (canLearn)
                answer++;
        }

        return answer;
    }
}