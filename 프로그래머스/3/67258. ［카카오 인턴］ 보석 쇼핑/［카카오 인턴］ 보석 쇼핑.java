import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
       
        Set<String> gemSet = new HashSet<>(Arrays.asList(gems));
        Map<String, Integer> quantityMap = new HashMap<>();


        int left = 0;
        int right = 0;
        final int LEN = gemSet.size();
        int curLen = 100000;
        int ansLeft = 0;
        int ansRight = 0;
        
        quantityMap.put(gems[0], 1);

        while (right < gems.length && left <= right) {
            if (quantityMap.size() < LEN){
                if(right < gems.length - 1){
                    right++;
                    String gem = gems[right];
                    quantityMap.put(gem, quantityMap.getOrDefault(gem, 0) + 1);
                }
                else {
                    right++;
                }
            }
            else { // quantityMap.size() == LEN
                int len = right - left;
                if (len < curLen){
                    curLen = len;
                    ansLeft = left;
                    ansRight = right;
                }
                int curValue = quantityMap.get(gems[left]);
                quantityMap.put(gems[left], curValue - 1);
                if (curValue == 1){
                    quantityMap.remove(gems[left]);
                }
                left++;
            }
        }
        answer[0] = ansLeft + 1;
        answer[1] = ansRight + 1;



        return answer;
    }
}