class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String converted = convert(n, k);

        String[] splitByZero = converted.split("0+");
        
        for (int i = 0; i < splitByZero.length; i++){
            long value = Long.parseLong(splitByZero[i]);
            if (value == 1)
                continue;
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(value); j++){
                if (value % j == 0){
                    isPrime = false;
                    break;
                }
                
            }
            if (isPrime)
                answer++;
        }

        return answer;
    }
    // 3 9 27 81 243
    public String convert(int n, int k){
        StringBuilder sb = new StringBuilder();

        while(n != 0){
            sb.append(n % k);
            n /= k;
        }
        sb = sb.reverse();

        return sb.toString();
    }

}