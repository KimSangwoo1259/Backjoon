class Solution {
    public int[] solution(int n, long left, long right) {
        final int LEN = (int )(right - left + 1);
        int[] answer = new int[LEN];
        for (int i = 0; i < LEN; i++){
            long cur = left + i;
            int q = (int) (cur / n);
            int r = (int) (cur % n);
            answer[i] = Math.max(q, r) + 1;
        }
        return answer;
    }
}