import java.util.*;

class Solution {
    public int solution(String[] board) {
        int answer = 1000000000;
        boolean found = false;
        int m = board.length;
        int n = board[0].length();
        char[][] map = new char[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<Horse> q = new LinkedList<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length(); j++){
                map[i][j] = board[i].charAt(j);
                if (board[i].charAt(j) == 'R'){
                    q.add(new Horse(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }
        while(!q.isEmpty()){
            Horse now = q.poll();
            boolean stop = false;
            for (int i = 1; now.x - i >= 0; i++){
                if(map[now.x-i][now.y] == 'D'){
                    stop = true;
                    if (map[now.x - i + 1][now.y] == 'G'){
                        answer = Math.min(answer, now.count + 1);
                        found = true;
                    }
                    else {
                        if (!visited[now.x-i+1][now.y]){
                            q.add(new Horse(now.x - i + 1, now.y, now.count + 1));
                            visited[now.x-i+1][now.y] = true;
                        }

                    }
                    break;
                }
            }
            if (!stop && !visited[0][now.y]){
                if (map[0][now.y] == 'G'){
                    answer = Math.min(answer, now.count + 1);
                    found = true;
                }
                else {
                    q.add(new Horse(0, now.y, now.count + 1));
                    visited[0][now.y] = true;
                }
            }
            stop = false;
            for (int i = 1; now.x + i < m; i++){
                if(map[now.x+i][now.y] == 'D'){
                    stop = true;
                    if (map[now.x + i - 1][now.y] == 'G'){
                        answer = Math.min(answer, now.count + 1);
                        found = true;
                    }
                    else {
                        if (!visited[now.x+i - 1][now.y]){
                            q.add(new Horse(now.x + i + -1, now.y, now.count + 1));
                            visited[now.x+i - 1][now.y] = true;
                        }

                    }
                    break;
                }
            }
            if (!stop && !visited[m-1][now.y]){
                if (map[m-1][now.y] == 'G'){
                    answer = Math.min(answer, now.count + 1);
                    found = true;
                }
                else {
                    q.add(new Horse(m - 1, now.y, now.count + 1));
                    visited[m - 1][now.y] = true;
                }
            }
            stop = false;
            for (int i = 1; now.y - i >= 0; i++){
                if(map[now.x][now.y - i] == 'D'){
                    stop = true;
                    if (map[now.x][now.y - i + 1] == 'G'){
                        answer = Math.min(answer, now.count + 1);
                        found = true;
                    }
                    else {
                        if (!visited[now.x][now.y - i + 1]){
                            q.add(new Horse(now.x, now.y - i + 1, now.count + 1));
                            visited[now.x][now.y - i + 1] = true;
                        }

                    }
                    break;
                }
            }
            if (!stop && !visited[now.x][0]){
                if (map[now.x][0] == 'G'){
                    answer = Math.min(answer, now.count + 1);
                    found = true;
                }
                else {
                    q.add(new Horse(now.x, 0, now.count + 1));
                    visited[now.x][now.y] = true;
                }
            }
            stop = false;
            for (int i = 1; now.y + i < n; i++){
                if(map[now.x][now.y + i] == 'D'){
                    stop = true;
                    if (map[now.x][now.y + i - 1] == 'G'){
                        answer = Math.min(answer, now.count + 1);
                        found = true;
                    }
                    else {
                        if (!visited[now.x][now.y + i - 1]){
                            q.add(new Horse(now.x, now.y + i - 1, now.count + 1));
                        visited[now.x][now.y + i - 1] = true;
                        }
                    }
                    break;
                }
            }
            if (!stop && !visited[now.x][n-1]){
                if (map[now.x][n-1] == 'G'){
                    answer = Math.min(answer, now.count + 1);
                    found = true;
                }
                else {
                    q.add(new Horse(now.x, n - 1, now.count + 1));
                    visited[now.x][n - 1] = true;
                }
            }
        }
        if (found)
            return answer;
        return -1;
    }
    static class Horse{
        int x,y, count;
        public Horse(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}