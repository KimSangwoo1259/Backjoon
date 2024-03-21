import java.util.*;

class Solution {
     public int[] solution(String[] maps) {
        PriorityQueue<Integer> ansList = getAnswerList(maps);
      
        if (ansList.isEmpty()){
            int[] ans = {-1};
            return ans;
        }

        final int SIZE = ansList.size();
        int[] answer = new int[SIZE];
        for (int i = 0; i < SIZE; i++){
            answer[i] = ansList.poll();
        }
        return answer;
    }
    public static PriorityQueue<Integer> getAnswerList(String[] maps){
        int row = maps.length;
        int col = maps[0].length();

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        PriorityQueue<Integer> answerList = new PriorityQueue<>();
        boolean[][] visited = new boolean[row][col];
        Queue<Island> islandQueue = new LinkedList<>();
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                int temp = 0;
                if (!visited[i][j] && maps[i].charAt(j) != 'X'){
                    islandQueue.add(new Island(i, j, Character.getNumericValue(maps[i].charAt(j))));
                    visited[i][j] = true;
                    while (!islandQueue.isEmpty()){
                        Island now = islandQueue.poll();
                        temp += now.value;
                        for (int k = 0; k < 4; k++){
                            int nx = now.x + dr[k];
                            int ny = now.y + dc[k];
                            if (nx >= 0 && nx < row && ny >= 0 && ny < col){
                                if (!visited[nx][ny] && maps[nx].charAt(ny) != 'X'){
                                    visited[nx][ny] = true;
                                    islandQueue.add(new Island(nx, ny, Character.getNumericValue(maps[nx].charAt(ny))));
                                }
                            }
                        }
                    }
                }

                if (temp != 0){
                    answerList.add(temp);
                }
            }
        }
        return answerList;
    }
    static class Island {
        int x,y,value;
        Island(int _x, int _y, int v){
            x = _x;
            y = _y;
            value = v;
        }

    }
}