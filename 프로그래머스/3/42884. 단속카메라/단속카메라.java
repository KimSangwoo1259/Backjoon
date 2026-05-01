import java.util.*;


class Solution {
    public int solution(int[][] routes) {
        int answer = 0;


  
        Arrays.sort(routes, (a1,a2) -> {
            if (a1[0] == a2[0])
                return a1[1] - a2[1];
            return a1[0] - a2[0];
        });

        int right = routes[0][1];
        for (int i = 1; i < routes.length; i++) {
            if (routes[i][0] <= right) {
                right = Math.min(right, routes[i][1]);
            }
            else {

                right = routes[i][1];
                answer++;
            }
        }

        answer++;
        return answer;



    }
}