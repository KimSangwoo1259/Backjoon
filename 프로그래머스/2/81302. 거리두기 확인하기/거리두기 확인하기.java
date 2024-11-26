import java.util.ArrayList;
import java.util.List;


class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        // 우상단 좌상단 우하단 좌하단
        int[] drD = {-1, -1, 1, 1};
        int[] dcD = {1, -1, 1, -1};

        List<Character[][]> characters = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Character[][] map = new Character[5][5];
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    map[j][k] = places[i][j].charAt(k);
                }
            }
            characters.add(map);
        }
        for (int i = 0; i < 5; i++) {
            Character[][] map = characters.get(i);
            boolean isAns = true;
            for (int j = 0; j < 5 && isAns; j++) {
                for (int k = 0; k < 5 && isAns; k++) {
                    if (map[j][k].equals('P')) {
                        // 상하 좌우 거리 1 조사
                        for (int l = 0; l < 4; l++) {
                            int nX = j + dr[l];
                            int nY = k + dc[l];
                            if (nX >= 0 && nX < 5 && nY >= 0 && nY < 5) {
                                if (map[nX][nY].equals('P')) {
                                    isAns = false;
                                    break;
                                }
                                // 상하좌우 거리 2 조사
                                int nX2 = nX + dr[l];
                                int nY2 = nY + dc[l];
                                if (nX2 >= 0 && nX2 < 5 && nY2 >= 0 && nY2 < 5) {
                                    if (map[nX2][nY2].equals('P') && !map[nX][nY].equals('X')) {
                                        isAns = false;
                                        break;
                                    }
                                }
                            }
                        }
                        // 대각선 조사
                        for(int l = 0; l < 4; l ++) {
                            int ndX = j + drD[l];
                            int ndY = k + dcD[l];
                            if (ndX >= 0 && ndX < 5 && ndY >= 0 && ndY < 5){
                                if (map[ndX][ndY].equals('P')){
                                    if (!map[ndX][k].equals('X') || !map[j][ndY].equals('X')){
                                        isAns = false;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            answer[i] = (isAns) ? 1 : 0;

        }
        return answer;
    }
}
// 