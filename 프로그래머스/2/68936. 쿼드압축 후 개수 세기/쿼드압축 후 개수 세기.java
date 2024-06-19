class Solution {
    int[] answer;
    public int[] solution(int[][] arr) {
        answer = new int[2];
        final int LEN = arr.length;
        divide(arr,0,0,LEN);
        return answer;
    }
    void divide(int[][] arr, int x, int y, int len){
        if (len == 1)
            answer[arr[x][y]]++;
        else{
            int val = arr[x][y];
            boolean allSame = true;
            for (int i = 0; i < len; i++){
                for (int j = 0; j < len; j++){
                    if (val != arr[x + i][y + j]){
                        allSame = false;
                        break;
                    }
                }
                if(!allSame)
                    break;
            }
            if (allSame)
                answer[arr[x][y]]++;
            else{
                divide(arr, x, y, len/2);
                divide(arr, x+len/2, y, len/2);
                divide(arr, x, y+len/2, len/2);
                divide(arr, x+len/2, y+len/2, len/2);
            }
        }
    }
}