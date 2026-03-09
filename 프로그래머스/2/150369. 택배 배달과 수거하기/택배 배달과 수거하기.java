class Solution {
    // 무조건 맨 뒤에 있는 친구들 부터 가야 하나? 그게 최선의 방법 일까?
    // 특정 알고리즘 사용 가능한가 dp, 이분탐색? 최소경로?
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int deliveryPosition = -1;
        int pickupPosition = -1;
        for (int i = n-1; i >= 0; i--){
            if (deliveries[i] != 0){
                deliveryPosition = i;
                break;
            }
        }

        for (int i = n-1; i >= 0; i--){
            if (pickups[i] != 0){
                pickupPosition = i;
                break;
            }
        }

        while(deliveryPosition >= 0 || pickupPosition >= 0){
            int deliveryCount = cap; // 최대 배달 가능
            int pickupCount = cap;
            answer += (Math.max(deliveryPosition, pickupPosition) + 1) * 2L;

            //배달
            if (deliveryPosition >= 0) {
                while (deliveryCount > 0 && deliveryPosition >= 0) {
                    int canDelivery = Math.min(deliveries[deliveryPosition], deliveryCount);
                    deliveries[deliveryPosition] -= canDelivery;
                    deliveryCount -= canDelivery;
                    if (deliveries[deliveryPosition] == 0)
                        deliveryPosition--;
                }
            }
  


            //픽업
            if (pickupPosition >= 0){
                while (pickupCount > 0 && pickupPosition >= 0){
                    int canPickup = Math.min(pickups[pickupPosition], pickupCount);
                    pickups[pickupPosition] -= canPickup;
                    pickupCount -= canPickup;
                    if (pickups[pickupPosition] == 0)
                        pickupPosition--;
                }
            }

            while (deliveryPosition >= 0 && deliveries[deliveryPosition] == 0)
                deliveryPosition--;

            while (pickupPosition >= 0 && pickups[pickupPosition] == 0)
                pickupPosition--;
        }
        


        return answer;
    }


}