import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        final int LENGTH = arr.length;

        int[] numArr = new int[LENGTH];
        
        for (int i = 0; i < LENGTH; i++) {
            numArr[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(numArr);

        answer += numArr[0] + " " + numArr[LENGTH - 1];
        
        return answer;
    }
}