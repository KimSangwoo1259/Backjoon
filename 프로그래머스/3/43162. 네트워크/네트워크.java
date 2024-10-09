import java.util.*;


class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        Queue<Computer> q = new LinkedList<>();

        for (int i = 0; i < n; i++){
            if(!visited[i]){
                System.out.println(i);
                answer++;
                q.add(new Computer(i));
                visited[i] = true;
                while(!q.isEmpty()){
                    Computer now = q.poll();
                    for (int j = 0; j < n; j++){
                        if(!visited[j] && computers[now.value][j] == 1){
                            q.add(new Computer(j));
                            visited[j] = true;
                        }
                    }
                }
            }
        }


        return answer;
    }
    static class Computer {
        int value;

        public Computer(int value) {
            this.value = value;
        }
    }
}