class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int len = arr.length;
        
        if (len == 1){
            return arr[0];
        }
        else if (len == 2){
            return lcm(arr[0], arr[1]);
        }

        answer = lcm(arr[0], arr[1]);
        
        for (int i = 2; i < len; i++){
            answer = lcm(answer, arr[i]);
        }
        
        return answer;
    }

    public int gcd(int a, int b){
        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    
    public int lcm (int a, int b){
        return a / gcd(a,b) * b;
    }
}
