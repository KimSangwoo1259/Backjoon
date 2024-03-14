class Solution {
    public int[] solution(int[] sequence, int k) {
        final int LEN = sequence.length;
            int[] sum = new int[LEN];
            sum[0] = sequence[0];
            for (int i = 1; i < LEN; i++){
                sum[i] = sum[i - 1] + sequence[i];
            }

            int lAns = 100000000;
            int rAns = 200000000;

            int left = 0;
            int right = 0;

            while (left <= right && left < LEN && right < LEN){

                int temp;
                if (left == 0)
                    temp = sum[right];
                else
                    temp = sum[right] - sum[left - 1];
                if (temp <= k){
                    if (temp == k){
                        if (right - left < rAns - lAns){
                            rAns = right;
                            lAns = left;
                        }
                    }
                    right++;
                }
                else
                    left++;



            }
            int[] answer = new int[2];
            answer[0] = lAns;
            answer[1] = rAns;
            return answer;
    }
}