import java.util.*;


class Solution {
    public int[] solution(int[] numbers) {
        int[] answer ={};

        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < numbers.length - 1; i++){
            for (int j = i + 1; j < numbers.length; j++){
                set.add(numbers[i] + numbers[j]);
            }
        }
        int index = 0;
        answer = new int[set.size()];
        for (int n : set){
            answer[index] = n;
            index++;
        }

        return answer;
    }
}