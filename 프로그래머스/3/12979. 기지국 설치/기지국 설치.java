class Solution {
     public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int range = w * 2 + 1;
        int pos = 1;
        final int LEN = stations.length;
        boolean end = false;

        for (int i = 0; i < LEN; i++) {
            int left = stations[i] - w;
            int right = stations[i] + w;
            if (left - pos > 0){
                int diff = left - pos;
                answer += diff / range;
                if(diff % range != 0)
                    answer++;
            }
            if (right < n){
                pos = right + 1;
            }
            else {
                end = true;
                break;
            }
        }

        if (!end){
            int diff = n - pos + 1;
            answer += diff / range;
            if(diff % range != 0)
                answer++;
        }
        return answer;
    }
}