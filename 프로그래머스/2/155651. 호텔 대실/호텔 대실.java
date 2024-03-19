import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        final int LEN = book_time.length;
        Reservation[] arr = new Reservation[LEN];
        PriorityQueue<Reservation> pq = new PriorityQueue<>(); // 예약 종료 시간 기준으로 min heap 구성
        for (int i = 0; i < LEN; i++){
            int start = toInt(book_time[i][0]);
            int end = toInt(book_time[i][1]);
            arr[i] = new Reservation(start, end);
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o.start)); // 예약 순서대로 정렬
        for (int i = 0; i < LEN; i++){
            while (!pq.isEmpty()){
                if (addTime(pq.peek().end,10) <= arr[i].start)
                    pq.poll();
                else
                    break;
            }
            pq.add(arr[i]);
            answer = Math.max(answer, pq.size());
        }
        return answer;
    }
    static class Reservation implements Comparable<Reservation>{
        int start;
        int end;
        Reservation(int s, int e){
            start = s;
            end = e;
        }
        @Override
        public int compareTo(Reservation that) {
            return this.end - that.end;
        }
    }
    static int toInt(String time){
        String temp = time.substring(0, 2) + time.substring(3, 5);
        return Integer.parseInt(temp);
    }
    static int addTime(int startTime, int addedTime){
        if (startTime % 100 >= 50){
            return startTime + addedTime + 40;
        }
        return startTime + addedTime;
    }
}