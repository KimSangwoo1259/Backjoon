import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        List<Integer>[] lists = new List[n + 1];
        for (int i = 1; i <=n; i++){
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i  < roads.length; i++){
            int start = roads[i][0];
            int end = roads[i][1];
            lists[start].add(end);
            lists[end].add(start);
        }

        for (int i = 0; i < sources.length; i++){
            int source = sources[i];
            if (source==destination){
                answer[i] = 0;
                continue;
            }
            boolean[] visited = new boolean[n + 1];
            boolean found = false;
            visited[source] = true;
            Queue<Pos> q = new ArrayDeque<>();

            q.add(new Pos(source, 0));
            int ans = -1;


            while(!q.isEmpty()){
                Pos now = q.poll();
             
                List<Integer> connect = lists[now.source];

                for (int c: connect){
                    if (c == destination){
                        found = true;
                        ans = now.level + 1;
                        break;
                    }
                    
                    if (!visited[c]){
                        visited[c] = true;
                        q.add(new Pos(c, now.level + 1));
                    }
                    
                }
                if (found)
                    break;
            }
            answer[i] = ans;

        }
        return answer;
    }
    class Pos {
        int source;
        int level;

        public Pos(int source, int level) {
            this.source = source;
            this.level = level;
        }
    }
}