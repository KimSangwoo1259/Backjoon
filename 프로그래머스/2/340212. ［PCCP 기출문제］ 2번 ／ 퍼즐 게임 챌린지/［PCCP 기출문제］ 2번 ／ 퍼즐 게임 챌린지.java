class Solution {
 public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = 100000;
        int mid = (left + right) / 2;

        final int LENGTH = times.length;
        while (left < right){ 
            long totalTime = calculateTime(diffs, times, LENGTH, mid);
            if (totalTime <= limit){
                right = mid;
            }
            else {
                left = mid + 1;
            }
            mid = (left + right) / 2;  
            System.out.println(mid);

        }


        return left;
    }

    public long calculateTime(int[] diffs, int[] times, int length, int level) {

        long totalTime = 0;
        for (int i = 0; i < length; i++) {
            if (level < diffs[i]) {
                int tryRepeat = diffs[i] - level;
                totalTime += (long) tryRepeat * times[i - 1] + (long) (tryRepeat + 1) * times[i];
            } else {
                totalTime += times[i];
            }
        }
        return totalTime;
    }
}