import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {


            List<Double> extentSum = new ArrayList<>();
            extentSum.add(0.0);
            int n = 1;
            double sum = calExtent(k, calCollatz(k));
            k = calCollatz(k);
            extentSum.add(sum);
            
            while(k != 1){
                int next = calCollatz(k);
                sum += calExtent(k,next);
                extentSum.add(sum);
                n++;
                k = next;
            }
            double[] extents = extentSum.stream().mapToDouble(Double::doubleValue).toArray();

            double[] answer = new double[ranges.length];

            for(int i = 0; i < ranges.length; i++){
                int start = ranges[i][0];
                int end = (ranges[i][1] <= 0) ? n + ranges[i][1] : ranges[i][1];

                if (start > end){
                    answer[i] = -1.0;
                }
                else {
                    answer[i] = extents[end] - extents[start];
                }
            }



            return answer;

        }

        boolean isEven(int n){
            return n % 2 == 0;
        }
        int calCollatz(int n){
            if (isEven(n)){
                return n/ 2;
            }
            else {
                return n * 3 + 1;
            }

        }
        double calExtent(int a, int b){
            return (double) (a + b) / 2;
        }
}