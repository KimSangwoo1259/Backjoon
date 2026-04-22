import java.util.ArrayDeque;
import java.util.Queue;

class Solution {

    public int solution(int[][] board) {
        int h = board.length;
        int w = board[0].length;
        int[][] visitedCost = new int[h][w];
        for (int i = 0 ; i < h; i++){
            for (int j = 0; j < w; j++){
                visitedCost[i][j] = Integer.MAX_VALUE;
            }
        }
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        Queue<Road> q = new ArrayDeque<>();

        if (board[0][1] != 1){
            q.add(new Road(0, 1, 100, 'E'));
            visitedCost[0][1] = 100;
        }
        if (board[1][0] != 1){
            q.add(new Road(1, 0, 100, 'S'));
            visitedCost[1][0] = 100;
        }

        while(!q.isEmpty()){
            Road now = q.poll();

            //북
            if (now.direction != 'S') {
                int Nx = now.x + dr[0];
                int Ny = now.y + dc[0];
                if (Nx >= 0 && Nx < h && Ny >= 0 && Ny < w && board[Nx][Ny] != 1) {
                    int nextCost = (now.direction == 'N') ? now.cost + 100 : now.cost + 600;
                    if (visitedCost[Nx][Ny]  >= nextCost - 400){
                        visitedCost[Nx][Ny] = Math.min(nextCost,visitedCost[Nx][Ny]);
                        q.add(new Road(Nx, Ny, nextCost, 'N'));
                    }
                }
            }

            //동
            if (now.direction != 'W'){
                int Nx = now.x + dr[1];
                int Ny = now.y + dc[1];
                if (Nx >= 0 && Nx < h && Ny >= 0 && Ny < w && board[Nx][Ny] != 1) {
                    int nextCost = (now.direction == 'E') ? now.cost + 100 : now.cost + 600;
                    if (visitedCost[Nx][Ny]  >= nextCost - 400){
                        visitedCost[Nx][Ny] = Math.min(nextCost,visitedCost[Nx][Ny]);
                        q.add(new Road(Nx, Ny, nextCost, 'E'));
                    }
                }

            }
            //남
            if (now.direction != 'N'){
                int Nx = now.x + dr[2];
                int Ny = now.y + dc[2];
                if (Nx >= 0 && Nx < h && Ny >= 0 && Ny < w && board[Nx][Ny] != 1) {
                    int nextCost = (now.direction == 'S') ? now.cost + 100 : now.cost + 600;
                    if (visitedCost[Nx][Ny]  >= nextCost - 400){
                        visitedCost[Nx][Ny] = Math.min(nextCost,visitedCost[Nx][Ny]);
                        q.add(new Road(Nx, Ny, nextCost, 'S'));
                    }
                }

            }
            //서
            if (now.direction != 'E'){
                int Nx = now.x + dr[3];
                int Ny = now.y + dc[3];
                if (Nx >= 0 && Nx < h && Ny >= 0 && Ny < w && board[Nx][Ny] != 1) {
                    int nextCost = (now.direction == 'W') ? now.cost + 100 : now.cost + 600;
                    if (visitedCost[Nx][Ny]  >= nextCost - 400){
                        visitedCost[Nx][Ny] = Math.min(nextCost,visitedCost[Nx][Ny]);
                        q.add(new Road(Nx, Ny, nextCost, 'W'));
                    }
                }

            }
        }




        return visitedCost[h-1][w-1];
    }
    public class Road {
        int x,y, cost;
        char direction; // W N E S

        public Road(int x, int y, int cost, char direction) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.direction = direction;
        }
    }
}