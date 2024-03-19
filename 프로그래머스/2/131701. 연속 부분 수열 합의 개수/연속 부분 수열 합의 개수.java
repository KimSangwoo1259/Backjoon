import java.util.*;
class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        final int LEN = elements.length;
        int[] sum = new int[LEN+1];
        sum[1] = elements[0];
        for (int i = 2; i <= LEN; i++){
            sum[i] = sum[i - 1] + elements[i - 1];
        }
        int totalSum = sum[LEN];
        for (int i = 1; i <= LEN; i++){
            for (int j = i; j <= LEN; j++){
                int temp = sum[j] - sum[i - 1];
                set.add(temp);
                set.add(totalSum - temp);
            }
        }

        return set.size()-1; // 0 제외
    }
}