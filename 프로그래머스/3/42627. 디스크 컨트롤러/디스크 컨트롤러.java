
import java.util.*;

class Solution {

    public int solution(int[][] jobs) {
        int answer = 0;
        int[] timeArr = new int[jobs.length];
        PriorityQueue<Job> jobPQ = new PriorityQueue<>();

        Arrays.sort(jobs, Comparator.comparingInt(j -> j[0]));
        int curTime = 0;
        int curIndex = 0;
        while(curIndex != jobs.length){
            if (jobPQ.isEmpty()){
                curTime = jobs[curIndex][0];
            }
            else {
                Job now = jobPQ.poll();
                curTime += now.workTime;
                timeArr[now.num] = curTime - now.reqTime;
            }

            while(jobs[curIndex][0] <= curTime){
                jobPQ.add(new Job(curIndex, jobs[curIndex][0], jobs[curIndex][1]));
                curIndex++;
                if (curIndex == jobs.length)
                    break;
            }
        }
        while(!jobPQ.isEmpty()){
            Job now = jobPQ.poll();
            curTime += now.workTime;
            timeArr[now.num] = curTime - now.reqTime;
        }
        for (int i = 0 ; i < jobs.length; i++){
            answer += timeArr[i];
        }

        return answer / jobs.length;
    }
    public class Job implements Comparable<Job>{
        int num,reqTime,workTime;

        public Job(int num, int reqTime, int workTime) {
            this.num = num;
            this.reqTime = reqTime;
            this.workTime = workTime;
        }

        @Override
        public int compareTo(Job o) {
            if (this.workTime != o.workTime){
                return this.workTime - o.workTime;
            }
            else {
                if (this.reqTime != o.reqTime){
                    return this.reqTime - o.reqTime;
                }
                else {
                    return this.num - o.num;
                }
            }
        }
    }
}