import java.util.*;

class Solution {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int index = 0;
        int curWeightSum = 0;
        int curTime = 0;
        Queue<Truck> trucks = new LinkedList<>();
        while(index < truck_weights.length){
            curTime++;
            while(!trucks.isEmpty()){
                if (curTime - trucks.peek().time >= bridge_length){
                    curWeightSum -= trucks.peek().weight;
                    trucks.poll();
                }
                else
                    break;
            }
            if(curWeightSum + truck_weights[index] <= weight && trucks.size() < bridge_length){
                curWeightSum += truck_weights[index];
                trucks.offer(new Truck(truck_weights[index], curTime));
                index++;
            }
        }
        Truck last = null;
        boolean isRemain = false;
        while(!trucks.isEmpty()){
            last = trucks.poll();
            isRemain = true;
        }
        if (isRemain)
            curTime += bridge_length - (curTime - last.time);

        return curTime;
    }
    //큐가 안비어있으면 맨앞에 있는 애가 만약 curTime - time > bridge_length 면 poll 하기?
    //bridge len = 5 이고 맨앞에 있는애가 1초에 들어왔어 그러면 7초에 다 건너는거잖아

    static class Truck {
        int weight;
        int time;

        public Truck(int weight, int time) {
            this.weight = weight;
            this.time = time;
        }
    }
}