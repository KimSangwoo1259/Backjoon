import java.util.*;

class Solution {
    int solution(int[][] land) {
        final int LEN = land.length;
        int[][] dp = new int[LEN][4];

        for (int i = 0; i < 4; i++)
            dp[0][i] = land[0][i];

        for (int i = 1; i < LEN; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (k != j)
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + land[i][j]);
                }
            }
        }

        return Arrays.stream(dp[LEN - 1]).max().getAsInt();
    }
}