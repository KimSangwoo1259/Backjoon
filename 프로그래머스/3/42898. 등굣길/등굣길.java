class Solution {

    public int solution(int m, int n, int[][] puddles) {


        final int mod = 1_000_000_007;
        long[][] dp = new long[n + 1][m + 1];
        boolean[][] isPuddle = new boolean[n + 1][m + 1];

        for (int i = 0; i < puddles.length;  i++){
            int x = puddles[i][0];
            int y = puddles[i][1];

            isPuddle[y][x] = true;
        }

        dp[1][1] = 1;
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                if ((i == 1 && j ==1) || isPuddle[i][j])
                    continue;
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % mod;

            }
        }

        return (int) dp[n][m];
    }


}
