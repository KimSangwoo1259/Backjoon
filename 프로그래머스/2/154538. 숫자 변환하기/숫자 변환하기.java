import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
            if (x == y)
                return answer;
            int[] dp = new int[y + 1];
            boolean[] visited = new boolean[y + 1];
            final int MAX = 100000000;
            Arrays.fill(dp, MAX);
            Queue<Num> q = new LinkedList<>();
            q.offer(new Num(x, 0));
            dp[x] = 0;
            visited[x] = true;
            while (!q.isEmpty()){
                Num now = q.poll();
                if (now.number == y){
                    break;
                }
                if (now.number + n <= y){
                    if (!visited[now.number + n]) {
                        dp[now.number + n] = Math.min(dp[now.number + n], dp[now.number] + 1);
                        visited[now.number + n] = true;
                        q.offer(new Num(now.number + n, dp[now.number + n]));
                    }
                }
                if (now.number * 2 <= y){
                    if (!visited[now.number * 2]) {
                        dp[now.number * 2] = Math.min(dp[now.number * 2], dp[now.number] + 1);
                        visited[now.number * 2] = true;
                        q.offer(new Num(now.number * 2, dp[now.number * 2]));
                    }
                    if (now.number * 3 <= y){
                        if (!visited[now.number * 3]) {
                            dp[now.number * 3] = Math.min(dp[now.number * 3], dp[now.number] + 1);
                            visited[now.number * 3] = true;
                            q.offer(new Num(now.number * 3, dp[now.number * 3]));
                        }
                    }
                }
            }
            answer = (dp[y] == MAX) ? -1 : dp[y];
            return answer;
    }
    static class Num{
        int number,times;
        Num(int n, int t){
            number = n;
            times = t;
        }
    }
}