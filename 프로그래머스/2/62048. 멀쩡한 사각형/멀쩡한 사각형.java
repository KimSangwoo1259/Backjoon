class Solution {
    public long solution(int w, int h) {
        long answer;


        int l;
        int s;

        if(w < h){
            l = h;
            s = w;
        }
        else {
            l = w;
            s = h;
        }
        answer = (long)l * (long) s;
        double rate = ((double) s / (double) l);
        double before = 0;
        for(int i = 1; i <= l; i++){
            double temp = rate * i;
            if (before != Math.floor(before) && temp != Math.floor(temp)) {
                if (Math.floor(temp) != Math.floor(before)){
                    answer--;
                }
            }
            answer--;
            before = temp;
        }

        return answer;
    }
}