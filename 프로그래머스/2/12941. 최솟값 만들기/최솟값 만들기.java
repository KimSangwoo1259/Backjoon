import java.util.Arrays;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        final int LEN = A.length;
        for(int i = 0; i < LEN; i++){
            answer += A[i] * B[LEN - 1 - i];
        }
        return answer;
    }
}