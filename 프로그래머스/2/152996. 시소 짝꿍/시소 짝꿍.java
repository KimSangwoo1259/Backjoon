import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;

        Map<Integer,Integer> weightMap =new HashMap<>();

        for (int i = 0; i < weights.length; i++){
            weightMap.put(weights[i], weightMap.getOrDefault(weights[i], 0) + 1);
        }
        List<Integer> keyList = new ArrayList<>(weightMap.keySet());
        Collections.sort(keyList);

        for (int key: keyList){
            long count = weightMap.get(key);

            // case 1: 자기들 끼리(1)
            if (count >= 2){
                answer += (count * (count - 1)) / 2;
            }

            // case 2: 1.5배
            if (key % 2 == 0 && key /2 * 3 <= 1000){
                long oppCount = weightMap.getOrDefault(key / 2 * 3,0);


                answer += (count * oppCount);
            }


            // case 3: 2 배
            if (key * 2 <= 1000){
                long oppCount = weightMap.getOrDefault(key * 2,0);

                answer += (count * oppCount);
            }


            // case 4: 1.333333... 배
            if (key % 3 == 0 && key / 3 * 4 <=1000){
                long oppCount = weightMap.getOrDefault(key / 3 * 4,0);

                answer += (count * oppCount);
            }
        }

        return answer;
    }
}