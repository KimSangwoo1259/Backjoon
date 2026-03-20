import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int ans = 0;
        Arrays.sort(citations);

        int len = citations.length;

        for (int i = 0; i < len; i++){
            ans = Math.max(ans, Math.min(citations[i], (len - i)));
        }
        return ans;
    }
}