class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        final int LEN = board.length;
        int[] dh = {1,0,-1,0};
        int[] dw = {0,1,0,-1};
    
        String center = board[h][w];
        
        for(int i = 0; i < 4; i++){
            int nh = h + dh[i];
            int nw = w + dw[i];
            
            if(nh >= 0 && nh < LEN && nw >= 0 && nw < LEN){
                if(center.equals(board[nh][nw]))
                    answer++;
            }
        }
        return answer;
    }
}