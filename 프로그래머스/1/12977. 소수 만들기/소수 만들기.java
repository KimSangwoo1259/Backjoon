class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        final int LEN = 3001;
        boolean[] prime = new boolean[LEN];

        for (int i = 2; i < LEN; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++){
                if (i % j == 0){
                    isPrime = false;
                    break;
                }
            }
            if (isPrime)
                prime[i] = true;
        }
        for (int i = 0; i < nums.length - 2; i++){
            for (int j = i + 1; j < nums.length - 1; j++){
                for (int k = j + 1; k < nums.length; k ++){
                    if (prime[nums[i] + nums[j] + nums[k]])
                        answer++;
                }
            }
        }

        return answer;
    }
}