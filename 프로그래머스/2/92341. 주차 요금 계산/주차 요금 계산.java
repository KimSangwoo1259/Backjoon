import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Solution {
   public int[] solution(int[] fees, String[] records) {
int standardTime = fees[0];
        int standardFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        Map<String, Integer> feeMap = new HashMap<>();
        Map<String, LocalTime> enterMap = new HashMap<>();
        final LocalTime lastTime = parse("23:59");

        for (String record : records) {
            String[] splitRecord = record.split(" ");

            LocalTime time = parse(splitRecord [0]);
            String carNumber = splitRecord [1];
            String state = splitRecord [2];

            if (state.equals("IN")){
                enterMap.put(carNumber, time);
            }
            else{
                int duration = (int) Duration.between(enterMap.get(carNumber),time).toMinutes();
                feeMap.put(carNumber, feeMap.getOrDefault(carNumber, 0) + duration);
                enterMap.remove(carNumber);
            }
        }
        Set<String> keySet = enterMap.keySet();
        for (String key : keySet) {
            int duration = (int) Duration.between(enterMap.get(key), lastTime).toMinutes();
            feeMap.put(key, feeMap.getOrDefault(key, 0) + duration);
        }
        Set<String> feeKeySet = feeMap.keySet();

        List<String> feeKeys = new ArrayList<>(feeKeySet);
        int[] answer = new int[feeKeys.size()];
        feeKeys.sort(Comparator.comparingInt(Integer::parseInt));



        for (int i = 0; i < feeKeys.size(); i++) {
            String feeKey = feeKeys.get(i);
            int feeTime = feeMap.get(feeKey);
            if (feeTime <= standardTime)
                answer[i] = standardFee;
            else {
                feeTime -= standardTime;

                answer[i] = standardFee + (feeTime / unitTime) * unitFee;

                if (feeTime % unitTime != 0)
                    answer[i] += unitFee;
            }
        }

        return answer;
    }
    
    public LocalTime parse(String time){
        return LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
    }
}