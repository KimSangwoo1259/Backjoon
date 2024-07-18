import java.util.Arrays;

class Solution {
    boolean[] visited;
    int answer = 0;
    int LEN;
    int [][]d;
    int h;

    public int solution(int k, int[][] dungeons) {
        h = k;
        d = Arrays.copyOf(dungeons, dungeons.length);
        LEN = dungeons.length;
        visited = new boolean[LEN];
        back(0);
        return answer;
    }
    void back(int n){
        boolean can = false;
        for (int i = 0; i < LEN; i++){
            if (!visited[i]&& h >= d[i][0]){
                visited[i] = true;
                can = true;
                h -= d[i][1];
                back(n+1);
                h += d[i][1];
                visited[i] = false;
            }
        }
        if (!can){
            answer = Math.max(answer, n);
        }
        
    }
}