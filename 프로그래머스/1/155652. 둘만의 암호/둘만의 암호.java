class Solution {
    public String solution(String s, String skip, int index) {
       String answer = "";
        boolean[] skipAlphabet = new boolean[26];
        char[] replaceAlphabet = new char[26];
        for (int i = 0; i < skip.length(); i++){
            skipAlphabet[(skip.charAt(i) - 'a')] = true;
        }
        for (int i = 0; i < 26; i++){
            int tempIndex = 0;
            while (tempIndex < index){
                replaceAlphabet[i]++;
                if (!skipAlphabet[(i + replaceAlphabet[i]) % 26])
                    tempIndex++;
            }
        }
        for (int i = 0; i < s.length(); i++){
            int temp = s.charAt(i) - 'a';
            temp = (temp + replaceAlphabet[temp]) % 26;
            answer += Character.toString((char) (temp + 'a'));
        }
        return answer;
    }
}