class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        final int LEN = sequence.length;
        int[] sequence1 = new int[LEN];// -1 1 -1 1
        int[] sequence2 = new int[LEN]; // 1 -1 1 -1
        for (int i = 0; i < LEN; i++) {
            sequence1[i] = sequence[i] * (int) Math.pow(-1, i + 1);
            sequence2[i] = sequence[i] * (int) Math.pow(-1, i + 2);
        }
        long[] dp1 = new long[LEN];
        long[] dp2 = new long[LEN];
        dp1[0] = sequence1[0];
        dp2[0] = sequence2[0];
        answer = Math.max(dp1[0],dp2[0]);
        for (int i = 1; i < LEN; i++) {
            dp1[i] = Math.max(dp1[i - 1], 0) + sequence1[i];
            dp2[i] = Math.max(dp2[i - 1], 0) + sequence2[i];
            answer = Math.max(answer, Math.max(dp1[i], dp2[i]));
        }

        return answer;
    }
}