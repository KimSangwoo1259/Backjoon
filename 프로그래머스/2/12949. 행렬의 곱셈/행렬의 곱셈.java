class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        final int midLen = arr1[0].length;
        final int newW = arr1.length;
        final int newH = arr2[0].length;
        int[][] answer = new int[newW][newH];

        for (int i = 0; i < newW; i++) {
            for (int j = 0; j < newH; j++) {
                int sum = 0;
                for (int k = 0; k < midLen; k++) {
                    sum += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = sum;
            }
        }

        return answer;
    }
}