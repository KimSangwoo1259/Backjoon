import java.util.PriorityQueue;

class Solution {
   PriorityQueue<String> pq;
    StringBuilder sb;
    char[] arr = {'A', 'E', 'I', 'O', 'U'};
    public int solution(String word) {
        int answer = 0;
        pq = new PriorityQueue<>();
        sb = new StringBuilder();
        
        dfs(0);
        
        
        while(!pq.isEmpty()){
            answer ++;
            String now = pq.poll();
            if (now.equals(word)){
                break;
            }
        }
        return answer;
        

    }
    public void dfs(int n){
        if (n == 5)
            return;
        for (int i = 0; i < 5; i++){
            sb.append(arr[i]);
            pq.add(sb.toString());
            dfs(n + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        
    }
}