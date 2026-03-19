
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        boolean found = false;
        
        for (int i = 3; i <700000; i++){
            for (int j = 1; j <=i; j++){
                int extent = i * j;
                int y = (i - 2) * (j - 2);
                int b = extent - y;
                
                if (b == brown && y == yellow){
                    answer[0] = i;
                    answer[1] = j;
                    found = true;
                    break;
                }
            }
            if (found)
                break;
        }
        
        return answer;
    }
}