import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        final int LEN = sticker.length;

        int[] dp1 = new int[LEN];
        int[] dp2 = new int[LEN];
        
        if (LEN == 1){
            return sticker[0];
        }
        else if (LEN == 2){
            return Math.max(sticker[0],sticker[1]);
        }

        dp1[0] = sticker[0];
        dp1[1] = Math.max(sticker[0], sticker[1]);

        dp2[1] = sticker[1];
        dp2[2] = Math.max(sticker[1], sticker[2]);

        for (int i = 2; i < LEN -1; i++){
            dp1[i] = Math.max(dp1[i-1],dp1[i-2]+sticker[i]);
        }
        for(int i = 3; i < LEN; i++){
            dp2[i] = Math.max(dp2[i-1],dp2[i-2]+sticker[i]);
        }

        int dp1Max = Arrays.stream(dp1).max().getAsInt();
        int dp2Max = Arrays.stream(dp2).max().getAsInt();

        return Math.max(dp1Max,dp2Max);
    } 
}