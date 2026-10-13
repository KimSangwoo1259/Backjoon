import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        //1번부터 최소거리
        int[] distance = new int [n+1];
        
        
        for(int i = 2; i <= n; i++){
            distance[i] = -1;
        }
        
        List<Integer>[] listArr = new List[n+1];
        
        for(int i = 1; i <=n; i++){
            listArr[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < edge.length; i++){
            int left = edge[i][0];
            int right = edge[i][1];
            
            listArr[left].add(right);
            listArr[right].add(left);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        
        queue.add(1);
        
        while(!queue.isEmpty()){
            int now = queue.poll();
            
            for(int i = 0; i < listArr[now].size(); i++){
                int target = listArr[now].get(i);
                
                if(distance[target] == -1){
                    distance[target] = distance[now] + 1;
                    queue.add(target);
                }
            }
        }
        int max = 0;
        for(int i = 2; i <=n; i++){
            max = Math.max(distance[i],max);
        }
        for(int i = 2; i <=n; i++){
            if(distance[i] == max)
                answer++;
        }
        
        return answer;
    }
}
// 간선 마다 거리를 잰다
// 그 거리들을 모두 기록
// 인접그래프로 해야겠는디?