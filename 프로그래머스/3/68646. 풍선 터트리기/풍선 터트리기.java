class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int len = a.length;
        int minIndex = 0;
        for (int i = 0; i < len; i++) {
            if (a[i] < a[minIndex]) {
                minIndex = i;
            }
        }
        answer++; // 값 제일 작은 풍선은 무조건 생존 가능
        if (minIndex == 0) {

            int curMinIndex = len - 1;
            answer++;// 맨 오른쪽도 무조건 생존 가능
            for (int i = len - 2; i >= 1; i--) {
                if (a[i] < a[curMinIndex]) {
                    curMinIndex = i;
                    answer++;
                }
            }
        } else if (minIndex == len - 1) {
            int curMinIndex = 0;
            answer++; // 맨 왼쪽도 무조건 생존 가능
            for (int i = 1; i < len - 1; i++) {
                if (a[i] < a[curMinIndex]) {
                    curMinIndex = i;
                    answer++;
                }
            }
        } else {
            answer += 2; // 양쪽끝 무조건 생존 가능
            int leftMinIndex = 0;
            int rightMinIndex = len - 1;

            for (int i = 1; i < minIndex; i++) {
                if (a[i] < a[leftMinIndex]) {
                    leftMinIndex = i;
                    answer++;
                }
            }
            for (int i = len - 2; i > minIndex; i--) {
                if (a[i] < a[rightMinIndex]) {
                    rightMinIndex = i;
                    answer++;
                }
            }

        }

        return answer;
    }
}