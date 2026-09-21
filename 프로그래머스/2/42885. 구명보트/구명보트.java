import java.util.*;


class Solution
{
    // 정렬 -> 가장 작은 사람 + 가장 큰 사람 가능여부? 리밋에 가깝게 하는게 나을거 같긴한데 30 40  60 70 80
    // 두포인터로 양끝으로 가서 만약 ㄱㄴ? 그러면 태우기 그리고 left ++  right --
    public int solution(int[] people, int limit) {
        int twoCount = 0;

        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;

        while(left < right){
            int leftWeight = people[left];
            int rightWeight = people[right];
            int totalWeight = leftWeight + rightWeight;

            if (totalWeight <= limit){
                twoCount++;
                left ++;
                right--;
            }
            else {
                right--;
            }
        }

        return people.length - twoCount;
    }

}