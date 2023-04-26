import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());

        Conf[] arr = new Conf[N];

        int count = 0; //사용할 수 있는 회의 개수
        int temStart;
        int temEnd;
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            temStart = Integer.valueOf(st.nextToken());
            temEnd = Integer.valueOf(st.nextToken());
            arr[i] = new Conf(temStart,temEnd);
        }
        Arrays.sort(arr, new Comparator<Conf>() {
            @Override
            public int compare(Conf o1, Conf o2) {
                if(o1.getEnd() == o2.getEnd()){
                    return  o1.getStart() - o2.getStart();
                }
                return o1.getEnd() - o2.getEnd();
            }
        }); // 종료 시간이 같은경우, 시작시간이 먼저인 것을 앞으로 해야함
        int curConfEndTime = arr[0].getEnd();
        count++;
        for(int i = 1; i < N; i++){
            if(arr[i].getStart() >= curConfEndTime){
                count++;
                curConfEndTime = arr[i].getEnd();
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();


    }
    static class Conf{
        private final int start;
        private final int end;

        public Conf(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }


    }
}
