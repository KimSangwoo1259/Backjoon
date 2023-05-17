import java.io.*;
import java.util.StringTokenizer;
// 앞에서 부터 순차적으로 반복문을 돌려 시간초과가 났지만 배열중 최댓값이 맨 앞에있는 경우 반복문을 멈추는 코드를 넣었더니 통과가 되었다. 운이좋았다
// 하지만 이문제를 더 빠르게 풀기 위해서는 뒤에서부터 max값을 초기화 해 가면서 주식의 이익 값을 구했다면, for문을 한번만 돌렸어도 됐다. 다음부턴 풀기전에 고민을 더 많이 하고 풀어보자
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.valueOf(st.nextToken());


        for(int j = 0; j < t; j++){
            long answer = 0L;
            st = new StringTokenizer(br.readLine());
            int n = Integer.valueOf(st.nextToken());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int l = 0; l <n; l++){
                arr[l] = Integer.valueOf(st.nextToken());
            }
            int curStart = 0;
            int count = 0;
            while (true){
                if(count == n+1)
                    break;
                int maxIndex = curStart;
                for (int i = curStart; i < arr.length; i++) {
                    if (arr[i] > arr[maxIndex])
                        maxIndex = i;
                }
                if (maxIndex == 0)
                    break;
                for (int k = curStart; k <= maxIndex; k++){
                    answer += (arr[maxIndex] - arr[k]);
                }
                if(maxIndex == n - 1)
                    break;
                curStart = maxIndex+1 ;
                count++;
            }
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();



    }
}
