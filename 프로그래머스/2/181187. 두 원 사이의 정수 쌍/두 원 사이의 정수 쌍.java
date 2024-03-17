class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        int temp = 0;
        int cur = r2;
        while (temp < r2){
            if (getDistance(temp,cur) <= r2 * r2){
                answer += cur * 4;
                temp++;
            }
            else {
                cur--;
            }
        }

        temp = 0;
        cur = r1;
        while (temp < r1){
            if (getDistance(temp,cur) < r1 * r1){
                answer -= cur * 4;
                temp++;
            }
            else {
                cur--;
            }
        }


        return answer;
    }
    public static long getDistance(int a, int b){
        return a * a + b * b;
    }
}
