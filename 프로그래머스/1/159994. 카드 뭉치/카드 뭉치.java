class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int leftIndex = 0;
        int rightIndex = 0;
        int goalIndex = 0;
        while (goalIndex < goal.length && leftIndex < cards1.length && rightIndex < cards2.length) {
            if (cards1[leftIndex].equals(goal[goalIndex]))
                leftIndex++;
            else if(cards2[rightIndex].equals(goal[goalIndex]))
                rightIndex++;
            else
                break;
            goalIndex++;
        }
        while (leftIndex < cards1.length && goalIndex < goal.length){
            if (cards1[leftIndex].equals(goal[goalIndex])) {
                leftIndex++;
                goalIndex++;
            }
            else
                break;
        }
        while (rightIndex < cards2.length && goalIndex < goal.length){
            if (cards2[rightIndex].equals(goal[goalIndex])){
                rightIndex++;
                goalIndex++;
            }
            else 
                break;
        }
        if (goalIndex == goal.length)
            return "Yes";
        return "No";
    }
}