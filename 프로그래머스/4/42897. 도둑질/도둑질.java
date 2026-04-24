class Solution {

    public int solution(int[] money) {
        final int LEN = money.length;
        
        if (LEN == 1){
            return money[0];
        }
        int[] dp1 = new int[LEN]; // 첫번째 털음 
        int[] dp2 = new int[LEN]; //첫번째 안털음

        dp1[0] = money[0];
        dp1[1] = money[0];

        dp2[1] = money[1];
        
        for (int i = 2; i < LEN -1; i++){
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + money[i]);
        }
        for (int i = 2 ; i < LEN; i++){
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + money[i]);
        }


        return Math.max(dp1[LEN-2],dp2[LEN-1]);
    }
}