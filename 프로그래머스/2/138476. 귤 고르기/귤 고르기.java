import java.util.*;

class Solution
{
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> tanMap = new HashMap<>();
        
        for (int i = 0; i < tangerine.length; i++){
            int tanSize = tangerine[i];
            tanMap.put(tanSize, tanMap.getOrDefault(tanSize, 0) + 1);
        }
        int[] tanValues = tanMap.values().stream().mapToInt(o -> o).toArray();

        Arrays.sort(tanValues);
        
        int sum = 0;
        for (int i = tanValues.length - 1; i >=0; i --){
            sum += tanValues[i];
            answer++;
            if (sum >= k)
                break;
        }
        
        return answer;
    }
    
}