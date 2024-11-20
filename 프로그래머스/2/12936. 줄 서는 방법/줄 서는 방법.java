

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        long[] factorial = new long[n+1];
        boolean[] used = new boolean[n+1];
        factorial[0] = 1;
        for(int i = 1; i <= n; i++){
            factorial[i] = factorial[i - 1] * i;
        }
        int index = 0;
        while(index < n){
            int value = 0;
            long temp = factorial[n - (index+1)];
            for(int i = 1; i <= n - index; i++){
                if (k <= i * temp){
                    k -= (i-1) * temp;
                    for(int j = 1; j <= n; j++){
                        if (used[j])
                            continue;
                        value++;
                        if (value == i){
                            answer[index] = j;
                            used[j] = true;
                        }
                    }
                    break;
                }
            }
            index++;
        }
        return answer;
    }
}
// 1 2