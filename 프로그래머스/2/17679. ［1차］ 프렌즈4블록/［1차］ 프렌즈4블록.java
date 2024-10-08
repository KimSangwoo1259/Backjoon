class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        int[] start = new int[n];
        char[][] boardC = new char[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                boardC[i][j] = board[i].charAt(j);
            }
        }
        
        while(true){
            boolean found = false;
            boolean[][] crashed = new boolean[m][n];


            for(int i = 0; i < m-1; i++){
                for(int j = 0; j < n-1; j++){
                    char now = boardC[i][j];
                    if (now != '.') {
                        if (now == boardC[i][j+1] && now == boardC[i+1][j] && now == boardC[i+1][j+1]) {
                            crashed[i][j] = true;
                            crashed[i][j + 1] = true;
                            crashed[i + 1][j] = true;
                            crashed[i + 1][j + 1] = true;
                            found = true;
                        }
                    }
                }
            }


            for (int i = 0; i < n; i++){
                int count = 0;
                for (int j = m-1; j >= start[i]; j--){
                    if (crashed[j][i]){
                        count++;
                    }
                    else {
                        if (count > 1){
                            boardC[j+count][i] = boardC[j][i];
                        }
                    }
                }
                for(int k = start[i]; k < start[i] + count; k++){
                    boardC[k][i] = '.';
                }
                start[i] += count;
                answer += count;
            }

            
            if (!found)
                break;
        }


        return answer;
    }
}