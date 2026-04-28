import java.util.Stack;

import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int LEN = prices.length;
        int[] answer = new int[LEN];
        Stack<Integer> stack = new Stack<>(); // 가격이 아닌 '인덱스'를 담는 스택

        for (int i = 0; i < LEN; i++) {
            // 1. 현재 가격이 스택 최상단(이전 가격)보다 떨어졌는지 확인
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int index = stack.pop();
                // 2. 가격이 떨어진 지점(i)과 구매 시점(index)의 차이를 저장
                answer[index] = i - index;
            }
            // 3. 현재 시점의 인덱스를 스택에 추가
            stack.push(i);
        }

        // 4. 끝까지 가격이 떨어지지 않은 나머지 시점들 처리
        while (!stack.isEmpty()) {
            int index = stack.pop();
            answer[index] = LEN - 1 - index;
        }

        return answer;
    }
}