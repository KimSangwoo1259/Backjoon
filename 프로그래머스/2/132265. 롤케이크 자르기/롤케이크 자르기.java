import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int len = topping.length;
        int[] toppingCount1 = new int[10001];
        int[] toppingCount2 = new int[10001];

        Set<Integer> toppingMap1 = new HashSet<>();
        Set<Integer> toppingMap2 = new HashSet<>();
        
        for (int i = 0; i < len; i++){
            toppingCount2[topping[i]]++;
            toppingMap2.add(topping[i]);
        }
        
        for (int i = 0; i < len; i++){
            int now = topping[i];
            
            toppingCount1[now]++;
            toppingCount2[now]--;
            toppingMap1.add(now);
            if (toppingCount2[now] == 0)
                toppingMap2.remove(now);
            
            if (toppingMap1.size() == toppingMap2.size())
                answer++;
            
            
        }
        
        return answer;
    }
}
