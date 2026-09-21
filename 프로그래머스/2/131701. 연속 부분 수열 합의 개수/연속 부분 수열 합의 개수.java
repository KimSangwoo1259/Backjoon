import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int len = elements.length;

        Set<Integer> set = new HashSet<>();


        int[] newElements = new int[len + 1];
        for (int i = 1; i <= len; i++){
            newElements[i] = elements[i - 1];
        }

        int[] sum = new int[len+1];

        for (int i= 1; i <=len;i ++){
            sum[i] = newElements[i] + sum[i - 1];
        }
        int totalSum = sum[len];

        //i : 길이 j : 시작점
        for (int i = 1; i <= len; i ++){
            for (int j = 0; j + i <= len; j++){
                int partSum = sum[i + j] - sum[j];
                int otherPartSum = totalSum - partSum;

                set.add(partSum);
                set.add(otherPartSum);
            }
        }
        set.remove(0);

        return set.size();
    }
}
