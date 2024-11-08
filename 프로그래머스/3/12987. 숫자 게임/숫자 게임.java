import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        final int LEN = A.length;

        int[] descA = Arrays.stream(A).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        int[] descB = Arrays.stream(B).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();

        int aIndex = 0;
        int bIndex = 0;

        while (aIndex < LEN && bIndex < LEN) {
            if (descA[aIndex] < descB[bIndex]){
                aIndex++;
                bIndex++;
                answer++;
            }
            else {
                aIndex++;
            }
        }

        return answer;
    }
}