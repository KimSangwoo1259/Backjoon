class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];


        final int H = park.length;
        final int W = park[0].length();

        for (int i = 0; i < H; i++){
            for (int j = 0; j < W; j++){
                if (park[i].charAt(j) == 'S'){
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }

        for (int i = 0; i < routes.length; i++){
            int curX = answer[0];
            int curY = answer[1];
            boolean canGo = true;
            char direction = routes[i].charAt(0);
            int range = Character.getNumericValue(routes[i].charAt(2));

            for (int j = 0; j < range; j++){
                if (direction == 'E')
                    curY++;
                else if (direction == 'W')
                    curY--;
                else if (direction == 'S')
                    curX++;
                else  // W
                    curX--;
                if (curX >= 0 && curX < H && curY >= 0 && curY < W){
                    if (park[curX].charAt(curY) == 'X') {
                        canGo = false;
                        break;
                    }
                }
                else {
                    canGo = false;
                    break;
                }
            }
            if (canGo){
                answer[0] = curX;
                answer[1] = curY;
            }

        }
        return answer;
    }
}