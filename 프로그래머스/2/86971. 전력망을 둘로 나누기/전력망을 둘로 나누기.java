import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;

        boolean[][] graph = new boolean[n + 1][n + 1];

        // 초기값 설정
        for (int i = 0 ; i < n-1; i++){
            int left = wires[i][0];
            int right = wires[i][1];

            graph[left][right] = true;
            graph[right][left] = true;

        }

        // for 문 돌면서 하나씩 끊어 보면서 값 비교
        for (int i = 0; i < n-1; i++){
            int left = wires[i][0];
            int right = wires[i][1];


            graph[left][right] = false;
            graph[right][left] = false;

            boolean[] visited = new boolean[n + 1];
            int count = 0;

            Queue<Integer> queue = new ArrayDeque<>();

            queue.add(1);
            visited[1] = true;

            while(!queue.isEmpty()){
                Integer now = queue.poll();
                count++;
                for (int j = 1; j <=n; j++){
                    if (!visited[j] && graph[now][j]){
                        queue.add(j);
                        visited[j] = true;
                    }
                }
            }

            int dif = Math.abs(count - (n - count));

            if (dif < answer){
                answer = dif;
            }


            graph[left][right] = true;
            graph[right][left] = true;

        }


        return answer;
    }
}
