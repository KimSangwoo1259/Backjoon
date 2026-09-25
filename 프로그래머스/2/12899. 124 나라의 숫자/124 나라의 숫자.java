
class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();

        while(n > 0){
            int r = n % 3;
            int q = n /3;

            if (r != 0){
                sb.append(r);
                n = q;
            }
            else {
                sb.append(4);
                n = q - 1;
            }
        }


        return sb.reverse().toString();
    }

}