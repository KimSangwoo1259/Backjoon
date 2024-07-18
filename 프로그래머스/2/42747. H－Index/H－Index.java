import java.util.Arrays;


class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        boolean found = false;
        for (int i = 0; i < citations.length ; i++) {
            if (citations[citations.length - 1 - i] < i + 1){
                if (i == 0)
                    return 0;
                found = true;
                answer = Math.min(citations[citations.length - i], i);
                break;
                
            }
        }
        if (!found){
            answer = citations.length;
        }
        return answer;
    }
}