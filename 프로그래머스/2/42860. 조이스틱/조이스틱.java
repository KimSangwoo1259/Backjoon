import java.util.ArrayList;
import java.util.List;

class Solution {
    public  int solution(String name) {
        int changeCount = 0;
        int len =name.length();
        List<Integer> notAList = new ArrayList<>();
        for (int i = 0; i < len; i++){
            char now = name.charAt(i);
            if (now != 'A') {
                changeCount += Math.min(('A' - now + 26), (now - 'A'));
                notAList.add(i);
            }
        }

        if (!notAList.isEmpty()) {
            // 일방향 카운트 먼저 계산
            int moveCount = Math.min(notAList.get(notAList.size() - 1), len - notAList.get(0));
            for (int i = 0; i < notAList.size() - 1; i++) {
                int nowMoveCount = notAList.get(i) * 2 + len - notAList.get(i + 1);
                moveCount = Math.min(moveCount, nowMoveCount);
            }
            for (int i = notAList.size() -1; i >= 1; i--){
                int nowMoveCount = (len - notAList.get(i)) * 2 + notAList.get(i - 1);
                moveCount = Math.min(moveCount, nowMoveCount);
            }
            return changeCount + moveCount;
        }
        else {
            return changeCount;
        }


    }


}