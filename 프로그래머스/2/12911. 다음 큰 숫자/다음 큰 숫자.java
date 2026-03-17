class Solution {
    public int solution(int n) {
        int answer = 0;
        int target = Integer.bitCount(n);
        for (int i = n +1; true; i++){
            if (Integer.bitCount(i) == target){
                answer = i;
                break;
            }
        }
        return answer;
    }
}