import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> wantMap = new HashMap<>();
        final int WANT_LEN = want.length;
        final int DISCOUNT_LEN = discount.length;
        int totalAmount = 0;
        for (int i = 0 ; i < WANT_LEN; i++){
            wantMap.put(want[i], i);
            totalAmount += number[i];
        }
        int copyTotal = totalAmount;
        int[] countArr = new int[WANT_LEN];

        for (int i = 0; i < DISCOUNT_LEN - 9; i++){
            for (int j = i; j < i + 10; j++){
                if (!wantMap.containsKey(discount[j])){
                    break;
                }
                int index = wantMap.get(discount[j]);
                if (countArr[index] < number[index]){
                    countArr[index]++;
                    copyTotal--;
                    if (copyTotal == 0){
                        answer++;
                    }
                }
                else {
                    break;
                }
            }
            copyTotal = totalAmount;
            countArr = new int[WANT_LEN];
        }
        return answer;
    }
}