class Solution {
   public int[] solution(int n, int s) {
        int[] answer = new int[n];
        int sTemp = s;

        if(n > s){
            int[] fail = {-1};
            return fail;
        }

        for (int i = 0; i < n; i++) {
            answer[i] += sTemp / n;
            s -= sTemp / n;
        }
        for(int i = 0; i < s; i++){
            answer[n - 1 - i]++;
        }



        return answer;
    }
}