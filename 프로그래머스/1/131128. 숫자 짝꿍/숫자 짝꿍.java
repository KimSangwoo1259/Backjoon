class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        int[] xCount = new int[10];
        int[] yCount = new int[10];
        for (int i = 0; i < X.length(); i++){
            int a = Character.getNumericValue(X.charAt(i));
            xCount[a]++;
        }
        for (int i = 0; i < Y.length(); i++){
            int a = Character.getNumericValue(Y.charAt(i));
            yCount[a]++;
        }
        
        for (int i = 9; i >= 0; i--){
            int temp = Math.min(xCount[i], yCount[i]);
            if (i == 0 && sb.toString().isEmpty() && temp != 0){
                return "0";
            }
            for (int j = 0; j < temp; j++){
                sb.append(i);
            }
        }
        if (sb.toString().isEmpty())
            return "-1";
        
        return sb.toString();
    }
}