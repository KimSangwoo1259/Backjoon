class Solution {
    public int solution(String s) {
        int answer = 0;
        int matchChar = 0;
        int diffChar = 0;
        char curChar = s.charAt(0);
        for (int i = 0; i < s.length(); i++){
            if (matchChar == 0){
                answer++;
                curChar = s.charAt(i);
                matchChar++;
            }
            else {
                if (s.charAt(i) == curChar)
                    matchChar++;
                else
                    diffChar++;
                if (matchChar == diffChar){
                    matchChar = 0;
                    diffChar = 0;
                }

            }
        }
        return answer;
    }
}