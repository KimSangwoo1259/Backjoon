import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        final int LEN = numbers.length;
            int[] answer = new int[LEN];
            answer[LEN - 1] = -1;
            Stack<Integer> st = new Stack<>();
            st.push(numbers[LEN - 1]);

            for (int i = LEN -2; i >=0; i--){
                while (!st.isEmpty()){
                    if (st.peek() > numbers[i]){
                        answer[i] = st.peek();
                        break;
                    }
                    else {
                        st.pop();
                    }
                }
                if (st.isEmpty())
                    answer[i] = -1;
                st.push(numbers[i]);

            }
            return answer;
    }
}
// 뒤에서 부터 -1 