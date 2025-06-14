

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0; // 증설된 서버 횟수
        int curServer = 0; // 현재 서버 대수
        int[] server = new int[24]; // 몇시에 서버 담겨져 있는지?

        for (int i = 0; i < 24; i++){
            // 일단 시작 전에 만료 서버 지우기
            if (i >= k){
                curServer -= server[i - k];
            }
            // 만약 curServer > player[i] / m 이라면
            int curNeedServer = players[i] / m;
            if (curNeedServer > curServer){
                int additionalNeedServer = curNeedServer - curServer;
                server[i] = additionalNeedServer;
                curServer += additionalNeedServer;
                answer += additionalNeedServer;
            }
            // needServer = player[i] / m - curServer
        }

        return answer;
    }
}