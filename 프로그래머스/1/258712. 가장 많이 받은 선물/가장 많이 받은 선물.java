import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> map = new HashMap<>();
        final int LEN = friends.length;
        for (int i = 0; i < LEN; i++){
            map.put(friends[i], i);
        }
        int[][] giveAndTake = new int[LEN][LEN];
        int[] count = new int[LEN];
        int[] answer = new int[LEN];
        for (int i = 0; i < gifts.length; i++){
            String[] g = gifts[i].split(" ");
            String giver = g[0];
            String taker = g[1];
            giveAndTake[map.get(giver)][map.get(taker)]++;
            count[map.get(giver)]++;
            count[map.get(taker)]--;
        }
        for (int i = 0; i < LEN; i++){
            for (int j = 0; j < LEN; j++){
                if (i == j)
                    continue;
                if (giveAndTake[i][j] > giveAndTake[j][i]) {
                    answer[i]++;
                    continue;
                }
                else if(giveAndTake[i][j] == giveAndTake[j][i]) {
                    if (count[i] > count[j])
                        answer[i]++;
                }
            }
        }
        return Arrays.stream(answer).max().getAsInt();
    }
}