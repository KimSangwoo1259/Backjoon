class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int temp = n;

        int count = 0; //자리수

        while (temp > 0){
            temp -= (int) Math.pow(3, count+1);
            count++;
        }
        int [] sum = new int[count+2];

        sum[1] = 1;

        for (int i = 2; i < sum.length; i++){
            sum[i] = sum[i - 1] + (int) Math.pow(3, i - 1);
        }


        for (int i = count; i > 1; i--){
            if (n - (int) Math.pow(3, i-1) * 3 >= sum[i - 1]){
                sb.append(4);
                n -= (int) Math.pow(3, i-1) * 3;
            }
            else if (n - (int) Math.pow(3, i-1) * 2 >= sum[i - 1]){
                sb.append(2);
                n -= (int) Math.pow(3, i-1) * 2;
            }
            else {
                sb.append(1);
                n -= (int) Math.pow(3, i-1) ;
            }

        }
        int last = (int)Math.pow(2, n - 1);
        sb.append(last);
        return sb.toString();
    }
}