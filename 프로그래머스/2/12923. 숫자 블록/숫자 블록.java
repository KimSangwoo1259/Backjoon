class Solution {
    public int[] solution(long begin, long end) {

        int beginI = (int)begin;
        int endI = (int)end;
        final int LEN = endI - beginI + 1;
        int[] answer = new int[LEN];
        int index = 0;
        if (beginI == 1){
            answer[0] = 0;
            index++;
        }
       while(index < LEN){
            answer[index] = 1;
            int temp = index + beginI;
            for(int i = 2; i <= Math.sqrt(temp); i++){
                if(temp % i == 0){
                    if(temp / i <= 10_000_000){
                        answer[index] = Math.max(answer[index], temp / i);
                    }
                    answer[index] = Math.max(answer[index],i);
                }
            }
            index++;
        }

        return answer;
    }
}