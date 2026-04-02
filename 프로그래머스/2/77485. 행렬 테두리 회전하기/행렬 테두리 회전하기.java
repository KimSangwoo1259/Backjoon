class Solution {

    public int[] solution(int rows, int columns, int[][] queries) {

        int[][] table = new int[rows][columns];
        int[] answer = new int[queries.length];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                table[i][j] = (i * columns) + (j + 1);
            }
        }

        for (int i = 0; i < queries.length; i++){
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] -1;
            int x2 = queries[i][2] -1;
            int y2 = queries[i][3] - 1;

            int min = 1000000;

            int curX = x1;
            int curY = y1;

            int w = x2 - x1;
            int h = y2 - y1;


            // 오른쪽
            int next = table[curX][curY];

            for (int j = 0; j < h; j++){
                min = Math.min(min, next);
                int temp = table[curX][curY + 1];
                table[curX][curY+1] = next;
                next = temp;
                curY++;
            }
            System.out.println();
            //아래
            for (int j = 0; j < w ; j++){
                min = Math.min(min, next);
                int temp = table[curX + 1][curY];
                table[curX+1][curY] = next;
                next = temp;
                curX++;
            }
            System.out.println();
            //왼쪽
            for (int j = 0; j < h; j++){
                min = Math.min(min, next);
                int temp = table[curX][curY - 1];
                table[curX][curY-1] = next;
                next = temp;
                curY--;
            }
            System.out.println();
            //위쪽
            for (int j = 0; j < w; j++){
                min = Math.min(min, next);
                int temp = table[curX - 1][curY];
                table[curX-1][curY] = next;
                next = temp;
                curX--;
            }
            answer[i] = min;
        }




        return answer;
    }

}
