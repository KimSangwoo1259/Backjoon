class Solution {
   public int solution(String[] board) {
        int answer = 1;

        int oCount = 0;
        int xCount = 0;

        final int LENGTH = 3;

        int o = 0;
        int x = 0;

        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j < LENGTH; j++) {
                if(board[i].charAt(j) == 'O') {
                    oCount++;
                }
                else if(board[i].charAt(j) == 'X') {
                    xCount++;
                }
            }
        }
        if (oCount - xCount > 1 || oCount - xCount  < 0) // 2)
            return 0;

        for (int i = 0; i < LENGTH; i++) {
            boolean isO = true;
            boolean isX = true;
            for (int j = 0; j < LENGTH; j++) {
                if(board[i].charAt(j) != 'O')
                    isO = false;
                if(board[i].charAt(j) != 'X')
                    isX = false;
            }
            if(isO)
                o++;
            if(isX)
                x++;
           isO = true;
           isX = true;
           for (int j = 0; j < LENGTH; j++) {
               if (board[j].charAt(i) != 'O')
                   isO = false;
               if (board[j].charAt(i) != 'X')
                   isX = false;
               
           }
           if (isO)
               o++;
           if(isX)
               x++;

        }
       
       if (board[0].charAt(0) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(2) == 'O')
            o++;
        if (board[0].charAt(0) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(2) == 'X')
            x++;


        if (board[2].charAt(0) == 'O' && board[1].charAt(1) == 'O' && board[0].charAt(2) == 'O')
            o++;
        if (board[2].charAt(0) == 'X' && board[1].charAt(1) == 'X' && board[0].charAt(2) == 'X')
            x++;
        if (o > 0 && x > 0) // 1)
            return 0;
        if (o > 0 && (oCount - xCount != 1))
            return 0;
        
        if (x > 0 && (oCount != xCount)){
            return 0;
        }
        

        return answer;
    }
}