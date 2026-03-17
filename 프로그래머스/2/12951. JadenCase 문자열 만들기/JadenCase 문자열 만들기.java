class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean beforeBlank = true;
        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            
            if (now == ' ')
                beforeBlank = true;
            else {
                if (beforeBlank && Character.isLowerCase(now)){
                    now = Character.toUpperCase(now);
                }
                else if (!beforeBlank && Character.isUpperCase(now)){
                    now = Character.toLowerCase(now);
                }
                beforeBlank = false;
            }

            sb.append(now);
        }
        return sb.toString();
    }
}