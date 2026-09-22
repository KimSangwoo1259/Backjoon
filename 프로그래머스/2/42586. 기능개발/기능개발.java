import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int len = progresses.length;
        
        // 걸리는 날짜들을 배열로 만들기
        // 연속으로 감소하는수열이 어디서 끊기는지 보는거랑 똑같은거 같은디??
        int[] days = new int[len];
        
        for (int i = 0; i < len; i++){
            int remainProcess = 100 - progresses[i];

            int day = remainProcess / speeds[i];
            
            if (remainProcess % speeds[i] != 0)
                day++;

            days[i] = day;
        }
        List<Integer> ans = new ArrayList<>();
        int count = 1;
        int curValue = days[0];
        
        int i = 1;
        while(i < len){
            if (days[i] > curValue){
                ans.add(count);
                curValue = days[i];
                count = 1;
            }
            else {
                count++;
            }
            i++;
        }
        ans.add(count);
        
        return ans.stream().mapToInt(a->a).toArray();
    }
}
