import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[progresses.length];
        List<Integer> ans = new ArrayList<>();
        final int complete = 100;
        for (int i = 0; i < progresses.length; i++) {
            int remain = complete - progresses[i];
            days[i] += remain / speeds[i];
            if (remain % speeds[i] != 0)
                days[i]++;
        }
        Stack<Integer> st = new Stack<>();
        st.push(days[0]);
        int max = days[0];
        for (int i = 1; i < days.length; i++){
            if (days[i] > max){
                max = days[i];
                ans.add(st.size());
                st = new Stack<>();
                st.add(days[i]);
            }
            else
                st.push(days[i]);
        }
        ans.add(st.size());
        int[] answer = ans.stream().mapToInt(Integer::intValue).toArray();
        return answer;

    }
}