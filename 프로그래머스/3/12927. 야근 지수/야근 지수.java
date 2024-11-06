import java.util.*;
import java.util.stream.IntStream;
class Solution {
public long solution(int n, int[] works) {
            long answer = 0;
            final int LEN = works.length;
            int index = 0;
            int[] realWorks = IntStream.of(works)
                            .boxed()
                    .sorted(Comparator.reverseOrder())
                    .mapToInt(Integer::intValue).toArray();

            while(n > 0) {
                for(int i = index; i < LEN - 1; i++) {
                    if(realWorks[i] == realWorks[i+1]){
                        index++;
                    }
                    else {
                        break;
                    }
                }
                for(int i = 0; i <= index; i++){
                    if (n > 0) {
                        realWorks[i]--;
                        n--;
                    }
                }
                
                if(realWorks[index] == 0)
                    break;
                
            }
            for(int i = 0; i < LEN; i++){
                answer += (long) Math.pow(realWorks[i], 2);
            }

            return answer;
        }
}