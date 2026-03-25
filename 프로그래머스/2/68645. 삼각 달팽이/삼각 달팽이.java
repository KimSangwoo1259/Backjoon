class Solution {


    public int[] solution(int n) {
        final int LEN = n * (n + 1) / 2;
        int[] answer = new int[LEN];

        int count = 1;
        int index = 0;
        int row = 0;
        int level = n;
        while (count <= LEN){
            //cycle 1 -> 좌측 하단 방향
            for (int i = 0; i < level; i++){
                index += row;
                answer[index] = count;
                count++;
                row++;

            }
            level--;
            //cycle 2 -> 우측 직선으로
            for (int i = 0; i < level; i++){
                answer[++index] = count;
                count++;
            }
            level--;
            //cycle 3-> 좌측 상단 방향
            for (int i = 0; i < level; i++){
                index -= row;
                answer[index] = count;
                row--;
                count++;
            }
            level--;
        }

        return answer;
    }

}
