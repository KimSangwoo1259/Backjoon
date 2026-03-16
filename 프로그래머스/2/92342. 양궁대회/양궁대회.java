class Solution {
    int[] arr;
    int s; //현재 최고점수차이
    public int[] solution(int n, int[] info) {

        int[] arrows = new int[11];
        arr = new int[11];
        s = -1;
        dfs(0, n,  arrows,info);

        if (s == -1)
            return new int[]{-1};

        return arr;

    }
    public void dfs(int now,int remain, int[] arrows, int[] info){
        if (now == 11){
            if (remain > 0){
                arrows[10] += remain;
            }
            int[] scores = calculateScore(info, arrows);
            int apeach = scores[0];
            int ryan = scores[1];
            int dif = ryan - apeach;
            if (apeach < ryan) {
                if (s < dif) {
                    for (int i = 0; i < 11; i++) {
                        arr[i] = arrows[i];
                    }
                    s = dif;
                }
                else if (s == dif){
                    boolean change = false;
                    for (int i = 10; i >= 0; i--){
                        if (arrows[i] > arr[i]){
                            change = true;
                            break;
                        }
                        else if (arr[i] > arrows[i])
                            break;
                    }
                    if (change){
                        for (int i = 0; i < 11; i++) {
                            arr[i] = arrows[i];
                        }
                    }
                }
            }
            arrows[10] = 0;
            return;
        }

        if (remain > info[now]){
            arrows[now] = info[now] + 1;
            dfs(now + 1, remain - (info[now] + 1),  arrows,info);
            arrows[now] = 0;
        }
        dfs(now + 1, remain, arrows,info);

    }
    public int[] calculateScore(int[] info, int[] arrows){
        int[] ret = new int[2];

        int apeach = 0;
        int ryan = 0;

        for (int i = 0; i < 11; i++){
            if (info[i] == 0 && arrows[i] == 0)
                continue;
            if (info[i] >= arrows[i])
                apeach += (10 - i);
            else
                ryan += (10 - i);
        }
        ret[0] = apeach;
        ret[1] = ryan;

        return ret;
    }

}