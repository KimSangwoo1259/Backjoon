class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];

        int[] sum = new int[sequence.length];
        int len = 10000000;
        sum[0] = sequence[0];

        for (int i = 1; i < sequence.length; i++){
            sum[i] = sum[i - 1] + sequence[i];
        }

        int left = 0; int right = 0;

        while(left <= right && right < sequence.length){
            int temp;
            if (left == 0){
                temp = sum[right];
            }
            else {
                temp = sum[right] - sum[left - 1];
            }
            if (temp > k){
                left++;

            }else if (temp < k){
                right++;
            }
            else {
                int tempLen = right - left;

                if (tempLen < len){
                    answer[0] = left;
                    answer[1] = right;
                    len = tempLen;
                }
                right++;
                left++;
            }
        }

        return answer;
    }
}