import java.util.Arrays;


class Solution {
    public int solution(int[][] triangle) {
        final int LEN = triangle.length;

        int[][] dp = new int[LEN][LEN];
        dp[0][0] = triangle[0][0];


        for(int i = 1; i < LEN; i++){
            for(int j = 0; j <= i; j++){
                if (j == 0){
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                }
                else if (j == i){
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
                }
            }
        }


        return Arrays.stream(dp[LEN-1]).max().getAsInt();
    }
}