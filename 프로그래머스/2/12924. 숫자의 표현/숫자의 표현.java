class Solution
{
    public int solution(int n) {
        int answer = 0;

        int[] sum = new int[n + 1];
        for (int i = 1; i <=n; i++){
            sum[i] = i+ sum[i-1];
        }
        
        int left = 1; int right = 1;
        
        while(left <= right && right <= n){
            int value = sum[right] - sum[left - 1];
            if (value > n)
                left++;
            else if (value < n)
                right++;
            else{
                answer++;
                left++;
            }
        }
        return answer;
    }
}