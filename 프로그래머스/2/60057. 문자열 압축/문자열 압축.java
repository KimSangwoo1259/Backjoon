class Solution {
    public int solution(String s) {
        int max = s.length() / 2;
        int shortenLen = 0;
        String temp = "";
        for (int i = 1; i <= max; i++) {
            int tempShort = 0;
            int index = 0;
            int count = 1;
            while(index < s.length()) {
                int endIndex = Math.min(s.length(), index + i);
                String cur = s.substring(index, endIndex);
                if (temp.equals(cur)){
                    count++;
                }
                else {
                    if (count > 1){
                if (count < 10)
                    tempShort += i * (count - 1) - 1;
                else if(count >= 10 && count < 100)
                    tempShort += i * (count - 1) - 2;
                else if (count >= 100 && count < 1000)
                    tempShort += i * (count - 1) - 3;
                else if (count >= 1000)
                    tempShort += i * (count - 1) - 4;
            }
                    count = 1;
                    temp = cur;
                }
                index += i;
            }
            if (count > 1){
                if (count < 10)
                    tempShort += i * (count - 1) - 1;
                else if(count >= 10 && count < 100)
                    tempShort += i * (count - 1) - 2;
                else if (count >= 100 && count < 1000)
                    tempShort += i * (count - 1) - 3;
                else if (count >= 1000)
                    tempShort += i * (count - 1) - 4;
            }
            shortenLen = Math.max(tempShort, shortenLen);
        }
        int answer = s.length() - shortenLen;
        return answer;
    }
}