import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.valueOf(br.readLine());

        int[] arr = new int[n + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++){
            deque.add(i);
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++){
            arr[i] = Integer.valueOf(st.nextToken());
        }

        while (true){
            int index = deque.getFirst();
            bw.write(index + " ");
            deque.removeFirst();

            if (deque.isEmpty())
                break;

            if(arr[index] >0){
                for (int j = 0; j < arr[index]-1; j++){
                    deque.addLast(deque.getFirst());
                    deque.removeFirst();
                }
            }else {
                for (int j = 0; j < Math.abs(arr[index]); j++){
                    deque.addFirst(deque.getLast());
                    deque.removeLast();
                }
            }
        }

        bw.flush();
        bw.close();

    }
}