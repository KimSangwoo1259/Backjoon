import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = 100;

        int[][] graph = new int[n + 1][n + 1];
        
        for (int i = 0; i < wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        
        for (int i = 0; i < n-1; i++){
            boolean[] visited = new boolean[n + 1];
            int a = wires[i][0];
            int b = wires[i][1];
            
            graph[a][b] = 0;
            graph[b][a] = 0;

            int[] count = new int[2];
            int cnt = 0;
            for (int j = 1; j <= n; j++){
                int temp = 0;
                if (!visited[j]){
                    visited[j] = true;
                    Queue<Integer> q = new LinkedList<>();
                    q.add(j);
                    while(!q.isEmpty()){
                        Integer now = q.poll();
                        temp++;
                        for (int k = 1; k <= n; k++){
                            if (!visited[k] && graph[k][now] == 1){
                                q.add(k);
                                visited[k] = true;
                            }
                        }
                    }
                    if (temp != 0){
                        count[cnt] = temp;
                        cnt++;
                    }
                }
            }
            graph[a][b] = 1;
            graph[b][a] = 1;
            answer = Math.min(answer, Math.abs(count[0] - count[1]));
            
        }
        
        return answer;
    }
}