class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long pValue = Long.parseLong(p);
        final int LEN = p.length();
        for (int i = 0; i < t.length() - p.length() + 1; i++){
            long temp = Long.parseLong(t.substring(i, i + LEN));
            if (temp <= pValue)
                answer++;
        }
        return answer;
    }
}