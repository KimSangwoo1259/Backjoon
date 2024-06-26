import java.util.*;


class Solution {
   public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Process> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            q.add(new Process(i, priorities[i]));
        }
        Arrays.sort(priorities);
        int index = priorities.length - 1;
        while (true){
            Process p = q.poll();
            if (p.pri == priorities[index]){
                answer++;
                index--;
                if (p.loc == location){
                    break;
                }
            }
            else{
                q.offer(p);
            }
        }

        return answer;
    }
    public class Process {
        int loc;
        int pri;
        Process(int loc, int pri) {
            this.loc = loc;
            this.pri = pri;
        }
    }
}