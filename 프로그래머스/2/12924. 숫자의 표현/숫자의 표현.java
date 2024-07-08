class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] sum = new int[n+1];
        sum[1] = 1;
        for(int i=2;i<=n;i++){
            sum[i] = sum[i - 1] + i;
        }
        int left = 0;
        int right = 0;

        while(left<=right && right<=n){
            int temp = sum[right] - sum[left];
            if (temp < n)
                right++;
            else if(temp > n)
                left++;
            else{
                answer++;
                right++;
            }
        }
        return answer;
    }
}