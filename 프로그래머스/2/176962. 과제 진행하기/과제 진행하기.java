import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        Stack<Plan> wait = new Stack<>();

        List<Plan> planList = new ArrayList<>();
        
        int answerIndex = 0;
        for (int i = 0; i < plans.length; i++){
            String[] plan = plans[i];
            planList.add(new Plan(plan[0], convertToIntTime(plan[1]), Integer.parseInt(plan[2])));
        }
        planList.sort(Comparator.comparingInt(o -> o.time));
        
        // 멈춰둔 과제가 여러개 인 경우, 가장 최근에 멈춘 과제부터 시작(LIFO)
        // 진행중이던 과제가 끝났을때, 잠시 멈춘 과제가 있다면 멈춘 과제를 이어서 진행
        
        
        for (int i = 0; i <planList.size()-1; i++){
            Plan now = planList.get(i);
            Plan next = planList.get(i + 1);

            int usableTime = next.time - now.time;
            
            if (usableTime >= now.remain){
                usableTime -= now.remain;
                answer[answerIndex] = now.name;
                answerIndex++;
                if (!wait.isEmpty()){
                    while(!wait.isEmpty() && usableTime > 0){
                        Plan peek = wait.peek();
                        int useTime = Math.min(usableTime, peek.remain);
                        peek.remain -= useTime;
                         usableTime -= useTime;
                        if (peek.remain == 0){
                            answer[answerIndex] = wait.pop().name;
                            answerIndex++;
                        }
                    }
                }
            }
            else {
                now.remain -= usableTime;
                wait.push(now);
            }
        }
        answer[answerIndex] = planList.get(planList.size()-1).name;        
        answerIndex++;
        while(!wait.isEmpty()){
            answer[answerIndex] = wait.pop().name;
            answerIndex++;
        }
        return answer;
    }
    public int convertToIntTime(String time){
        String[] split = time.split(":");
        int hour = Integer.parseInt(split[0]);
        int minute = Integer.parseInt(split[1]);

       
        
        return hour * 60 + minute;
    }
    public class Plan {
        String name;
        int time;
        int remain;
        public Plan(String name, int time, int remain) {
            this.name = name;
            this.time = time;
            this.remain = remain;
        }
    }

}