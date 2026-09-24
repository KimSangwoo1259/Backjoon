import java.util.HashSet;
import java.util.Set;

class Solution {
    boolean[] used;
    Set<Integer> numSet;
    StringBuilder sb;
    String num;
    public int solution(String numbers) {
        used = new boolean[numbers.length()];
        numSet = new HashSet<>();
        sb = new StringBuilder();
        num = numbers;
        int answer = 0;
        back();
        for (int num : numSet){
            if (isPrime(num))
                answer++;
        }
        return answer;
    }

    public boolean isPrime (int value){
        if (value < 2)
            return false;

        boolean isPrime = true;

        for (int i = 2 ; i <= Math.sqrt(value); i++){
            if (value % i == 0){
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    public void back() {
        for (int i = 0; i < used.length; i++){
            if (used[i])
                continue;
            sb.append(num.charAt(i));
            used[i] = true;
            numSet.add(Integer.parseInt(sb.toString()));

            if (sb.length() != num.length()){
                back();
            }
            used[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}