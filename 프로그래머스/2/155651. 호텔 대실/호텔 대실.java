import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        Book[] bookArr = new Book[book_time.length];

        for (int i = 0; i < book_time.length; i++){
            bookArr[i] = new Book(book_time[i][0], book_time[i][1]);
        }
        Arrays.sort(bookArr);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0 ; i < bookArr.length; i++){
            Book now = bookArr[i];
            while(!pq.isEmpty() && (pq.peek() + 10) <= now.startTime){
                pq.poll();
            }
            pq.add(now.endTime);

            answer = Math.max(answer, pq.size());
        }

        return answer;
    }
    public class Book implements Comparable<Book> {
        int startTime;
        int endTime;

        @Override
        public int compareTo(Book o) {
            if (this.startTime != o.startTime){
                return this.startTime - o.startTime;
            }
            return this.endTime - o.endTime;
        }
        public Book(String startTimeStr, String endTimeStr){
            String[] startTimeSplit = startTimeStr.split(":");
            String[] endTimeSplit = endTimeStr.split(":");

            int startTime = Integer.parseInt(startTimeSplit[0]) * 60 + Integer.parseInt(startTimeSplit[1]);
            int endTime = Integer.parseInt(endTimeSplit[0]) * 60 + Integer.parseInt(endTimeSplit[1]);
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}
