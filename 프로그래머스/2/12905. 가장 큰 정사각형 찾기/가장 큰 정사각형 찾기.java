class Solution 
{
     public int solution(int [][]board) {
        int answer = 0;
        int m = board.length;
        int n = board[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 1){
                    if (i > 0 && j > 0){
                        dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1])) + 1;
                    }
                    else {
                        dp[i][j] = 1;
                    }
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }

        return answer * answer;
    }
}