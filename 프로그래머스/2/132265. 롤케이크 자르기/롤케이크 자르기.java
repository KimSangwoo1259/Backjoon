class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int[] countToppingLeft = new int[10001];
        int[] countToppingRight = new int[10001];
        int index = 0;
        int leftCount = 0;
        int rightCount = 0;
        for (int i = 0; i < topping.length; i++){
            if (countToppingRight[topping[i]] == 0){
                rightCount++;
            }
            countToppingRight[topping[i]]++;
        }
        while (index < topping.length){
            if (countToppingLeft[topping[index]] == 0)
                leftCount++;
            countToppingLeft[topping[index]]++;
            countToppingRight[topping[index]]--;
            if (countToppingRight[topping[index]] == 0)
                rightCount--;
            if (leftCount == rightCount)
                answer++;
            index++;
        }
        return answer;
    }
}