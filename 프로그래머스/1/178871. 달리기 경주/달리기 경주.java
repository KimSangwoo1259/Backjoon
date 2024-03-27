import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        final int LEN = players.length;
        Map<String, Integer> playerMap = new HashMap<>();
        for (int i = 0; i < LEN; i++){
            playerMap.put(players[i], i);
        }
        for (int i = 0; i < callings.length; i++){
            int calledPlayerIndex = playerMap.get(callings[i]);
            String behindPlayer = players[calledPlayerIndex - 1];
            playerMap.put(behindPlayer, calledPlayerIndex);
            playerMap.put(callings[i], calledPlayerIndex - 1);
            players[calledPlayerIndex] = behindPlayer;
            players[calledPlayerIndex - 1] = callings[i];
        }

        return players;
    }
}