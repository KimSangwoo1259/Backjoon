import java.util.*;

class Solution {


    // 그래프?
    // dp? ->
    // 분기점은 -> 힌트 살거야? 안살거야?
    public int solution(int[][] cost, int[][] hint) {
        int answer = Integer.MAX_VALUE;


        int len = cost.length;
        int[] arr = new int[len + 1];
        for (int i = 1; i < hint[0].length; i++){
            arr[hint[0][i]]++;
        }
        Queue<Stage> stageQueue = new LinkedList<>();
        List<Stage> stageList = new ArrayList<>();


        stageQueue.add(new Stage(0, new int[len + 1]));
        stageQueue.add(new Stage(hint[0][0], arr));

        int level = 1;
        while(!stageQueue.isEmpty()){
            int size = stageQueue.size();
            for (int i = 0; i < size; i++) {
                Stage now = stageQueue.poll();
                if (level == len-1) {
                    stageList.add(now);
                } else {
                    stageQueue.add(new Stage(now.cost, Arrays.copyOf(now.hints, len + 1)));
                    int[] hints = Arrays.copyOf(now.hints, len + 1);
                    for (int j = 1; j < hint[level].length; j++) {
                        hints[hint[level][j]]++;
                    }
                    stageQueue.add(new Stage(now.cost + hint[level][0], hints));
                }
            }
            level++;
        }

        for (Stage stage: stageList){
            int totalCost = stage.cost;

            for (int i = 0; i < cost.length; i++){
                int hintQuantity = Math.min(len - 1, stage.hints[i+1]);
                totalCost += cost[i][hintQuantity];
            }
            answer = Math.min(totalCost, answer);
        }


        return answer;
    }

    public class Stage {
        int cost;
        int[] hints;

        public Stage(int cost, int[] hints) {
            this.cost = cost;
            this.hints = hints;
        }
    }

}