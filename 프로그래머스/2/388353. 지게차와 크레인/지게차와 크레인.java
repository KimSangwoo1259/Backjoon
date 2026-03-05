import java.util.*;

class Solution {
    // 외부와 연결되어 있다의 판정은 어떻게 할까??
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        int n = storage.length;
        int m = storage[0].length();

        boolean[][] empty = new boolean[n][m];
        int reqLen = requests.length;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        List<Position>[] alphabetList = new List[26];

        for (int i = 0; i < 26; i++){
            alphabetList[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++){
            String str = storage[i];
            for (int j = 0; j < m; j++){
                int index = str.charAt(j) - 'A';
                alphabetList[index].add(new Position(i, j));
            }
        }

        for (int i = 0; i < reqLen; i++){
            String req = requests[i];

            int alphabet = req.charAt(0) - 'A';
            List<Position> alphabetPosition = alphabetList[alphabet];
            if (req.length() > 1){
                for (Position p: alphabetPosition){
                    empty[p.x][p.y] =true;
                }
                alphabetPosition.clear();
            }
            else {

                Iterator<Position> it = alphabetPosition.iterator();
                Queue<Position> willBeEmpty = new LinkedList<>();
                while (it.hasNext()){
                    Position p = it.next();
                    boolean exit = false;
                    boolean[][] visited = new boolean[n][m];

                    Queue<Position> q = new LinkedList<>();
                    visited[p.x][p.y] = true;
                    q.add(p);
                    while(!q.isEmpty()){
                        Position now = q.poll();
                        if (now.x == 0 || now.x == n -1 || now.y == 0 || now.y == m - 1){
                            exit = true;
                            break;
                        }
                        for (int j = 0 ; j < 4; j++){
                            int nx = now.x + dr[j];
                            int ny = now.y + dc[j];

                            if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && empty[nx][ny]){
                                visited[nx][ny] = true;
                                q.add(new Position(nx, ny));
                            }
                        }
                    }
                    if (exit){
                        willBeEmpty.add(p);
                        it.remove();
                        
                    }
                }
                while(!willBeEmpty.isEmpty()){
                    Position now = willBeEmpty.poll();
                    empty[now.x][now.y] = true;
                }


            }
        }
        for (int i= 0 ; i < 26; i++){
            answer += alphabetList[i].size();
        }
        return answer;
    }
    public class Position {
        int x,y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}