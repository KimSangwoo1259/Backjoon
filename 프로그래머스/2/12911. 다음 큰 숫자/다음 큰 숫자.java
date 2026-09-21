class Solution {
    public int solution(int n) {
        int answer = 0;
        int targetCount = countOne(n);
        
        for (int i = n +1; true; i++){
            if (targetCount == countOne(i)){
                answer = i;
                break;
            }
        }
        return answer;
    }
    public int countOne(int n){
        int count = 0;
        
        while(n > 0){
            if (n % 2 == 1)
                count++;
            n /= 2;
        }
        return count;
    }
}