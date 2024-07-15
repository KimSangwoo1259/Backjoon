import java.util.*;

class Solution {
     boolean[] used;
    StringBuilder sb;
    Set<Integer> set;
    String num;
    int answer;
    public int solution(String numbers) {
        answer = 0;
        num = numbers;
        used = new boolean[num.length()];
        set = new HashSet<>();
        sb = new StringBuilder();
        
        back();

        return answer;
    }

    void back(){
        for (int i = 0; i < num.length(); i++) {
            if (used[i]) continue;

            sb.append(num.charAt(i));
            used[i] = true;

            int n = Integer.parseInt(sb.toString());
        
            if (!set.contains(n)) {
                set.add(n);
                if (isPrime(n))
                    answer++;
            }
            if (sb.length() != num.length())
                back();

            used[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    boolean isPrime(int n){
        if (n < 2)
            return false;

        boolean isPrime = true;
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}