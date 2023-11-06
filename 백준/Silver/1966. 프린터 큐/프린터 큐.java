import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.valueOf(br.readLine());

        for (int i = 0; i < t; i++){
            Queue<Integer> queue = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.valueOf(st.nextToken()); // 문서 개수
            int m = Integer.valueOf(st.nextToken()); // 몇번 째 놓여있는지

            int count = 1;
            int curPos = m;
            st = new StringTokenizer(br.readLine());
            Integer[] arr = new Integer[n];
            for (int j = 0; j < n; j++){
                int temp = Integer.valueOf(st.nextToken());
                queue.add(temp);
                arr[j] = temp;
            }
            Arrays.sort(arr);
            while (true){
                int temp = queue.peek();
                if (temp == arr[n-count]){
                    if (curPos == 0){
                        bw.write(count +"\n");
                        break;
                    }
                    else {
                        queue.remove();
                        count++;
                        curPos--;
                    }
                }
                else {
                    int val = queue.remove();
                    queue.add(val);
                    if (curPos == 0)
                        curPos = queue.size() -1;
                    else
                        curPos--;
                }
            }

        }
        bw.flush();
        bw.close();

    }
}