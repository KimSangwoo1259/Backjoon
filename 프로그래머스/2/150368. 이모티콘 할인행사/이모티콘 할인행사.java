import java.util.*;

class Solution {
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        int len = emoticons.length;

        int[] discountRates = new int[len];
        Set<Integer> hashSet = new HashSet<>();
        Arrays.fill(discountRates, 10);

        Queue<int[]> q = new LinkedList<>();

        hashSet.add(calculateHashValue(discountRates));
        q.add(discountRates);

        while(!q.isEmpty()){
            int[] curDiscountRate = q.poll();

            int[] values = returnRegisterCountAndPrice(users, emoticons, curDiscountRate);

            if (values[0] > answer[0]){
                answer[0] = values[0];
                answer[1] = values[1];
            }
            else if (values[0] == answer[0]){
                answer[1] = Math.max(answer[1], values[1]);
            }


            for (int i = 0; i < curDiscountRate.length; i++){
                int[] clone = curDiscountRate.clone();
                clone[i] += 10;
                if (clone[i] <= 40 && !hashSet.contains(calculateHashValue(clone))){
                    hashSet.add(calculateHashValue(clone));
                    q.add(clone);
                }
            }

        }

        return answer;
    }

    public int calculateDiscountedPrice(int basePrice, int discountRate){
        return basePrice * (100 - discountRate) / 100;
    }

    public int[] returnRegisterCountAndPrice(int[][] users, int[] emoticons, int[] discountRates){
        int[] ans = new int[2];
        int registerCount = 0;
        int totalPrice = 0;
        for (int i = 0; i < users.length; i++){
            int sumPrice = 0;

            int threshHoldPercent = users[i][0];
            int threshHoldPrice = users[i][1];

            for (int j = 0; j < emoticons.length; j++){
                if (discountRates[j] >= threshHoldPercent){
                    sumPrice += calculateDiscountedPrice(emoticons[j], discountRates[j]);
                }
            }

            if (sumPrice >= threshHoldPrice){
                registerCount++;
            }
            else {
                totalPrice += sumPrice;
            }

        }
        ans[0] = registerCount;
        ans[1] = totalPrice;
        return ans;
    }

    public int calculateHashValue(int[] discountRates){
        int sum = 0;
        for (int i = 0; i < discountRates.length; i++){
            sum += (int) (Math.pow(5, i) * ((double) discountRates[i] / 10));
        }
        return sum;
    }
}