import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        final int LEN = order.length;
        int[] boxes = new int[LEN];
        for (int i = 0; i < LEN; i++){
            boxes[i] = i+1;
        }
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < LEN; i++){
            if (boxes[i] == order[answer]){
                answer++;
            }
            else {
                while (!st.isEmpty()){
                    if (st.peek() == order[answer]){
                        st.pop();
                        answer++;
                    }
                    else
                        break;
                }
                st.push(boxes[i]);
            }


        }
        while (!st.isEmpty()){
            if (st.peek() == order[answer]){
                st.pop();
                answer++;
            }
            else
                break;
        }

        return answer;
    }
}