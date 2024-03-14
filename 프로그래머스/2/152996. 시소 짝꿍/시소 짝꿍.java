class Solution {
    public long solution(int[] weights) {
        long answer = 0;
            long[] count = new long[1001];
            for (int i = 0; i < weights.length; i++){
                count[weights[i]]++;
            }

            for (int i = 100; i <= 1000; i++){
                if (count[i] >= 1){
                    long temp;
                    answer += (count[i] * (count[i] - 1)) / 2;
                    if (i % 3 == 0){
                        temp = i / 3 * 4;
                        if (temp<= 1000){
                            if (count[(int) temp] >= 1) {
                                answer += count[i] * count[(int) temp];
                            }
                        }
                    }
                    if (i % 2 == 0){
                        temp = i / 2 * 3;
                        if (temp<= 1000){
                            if (count[(int) temp] >= 1) {
                                answer += count[i] * count[(int) temp];
                            }
                        }
                    }
                    if (i * 2 <= 1000){
                        temp = i * 2;
                        if (count[(int) temp] >= 1)
                            answer += count[i] * count[(int)temp];
                    }
                }
            }
            return answer;
    }
}