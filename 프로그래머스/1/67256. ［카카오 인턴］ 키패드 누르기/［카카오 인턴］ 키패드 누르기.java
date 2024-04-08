class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int curLeftPos =10;
        int curRightPos = 12;
        for (int num : numbers){
            if (num ==0)
                num = 11;
            if (num % 3 == 1){
                sb.append("L");
                curLeftPos = num;
            }
            else if(num % 3 == 0){
                sb.append("R");
                curRightPos = num;
            }
            else { // 가운데
                int leftCount = 0;
                int rightCount = 0;
                if (num > curLeftPos){
                    leftCount += (num  - curLeftPos) / 3;
                    if (curLeftPos % 3 == 1)
                        leftCount++;
                }
                else if (num < curLeftPos){
                    if (curLeftPos % 3 == 1){
                        leftCount++;
                        leftCount += ((curLeftPos + 1) - num) / 3;
                    }
                    else {
                        leftCount += (curLeftPos - num) / 3;
                    }
                }
                if (num < curRightPos){
                    if (curRightPos % 3 == 0)
                        rightCount++;
                    rightCount += (curRightPos - num) / 3;
                }
                else if (num > curRightPos){
                    if (curRightPos % 3 == 0){
                        rightCount++;
                        rightCount += (num - (curRightPos - 1)) / 3;
                    }
                    else
                        rightCount += (num - curRightPos) / 3;
                }
                if (leftCount > rightCount){
                    sb.append("R");
                    curRightPos = num;
                }
                else if (rightCount > leftCount){
                    sb.append("L");
                    curLeftPos = num;
                }
                else{
                    if (hand.equals("right")){
                        sb.append("R");
                        curRightPos = num;
                    }
                    else {
                        sb.append("L");
                        curLeftPos = num;
                    }
                }

            }
        }

        return sb.toString();
    }
}