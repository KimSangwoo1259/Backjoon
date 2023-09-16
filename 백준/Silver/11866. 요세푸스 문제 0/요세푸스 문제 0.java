import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());
        int k = Integer.valueOf(st.nextToken());
        int count = 0;
        List<Integer> numList = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++){
            queue.add(i);
        }
        while(!queue.isEmpty()){
            count++;
            if (count == k){
                numList.add(queue.peek());
                queue.remove();
                count = 0;
            }
            else {
                int num = queue.peek();
                queue.remove();
                queue.add(num);
            }
        }
        bw.write("<");
        for (int i = 0; i < n-1; i++){
            bw.write(numList.get(i) + ", ");
        }
        bw.write(numList.get(n-1) + ">");
        bw.flush();
        bw.close();

    }
}