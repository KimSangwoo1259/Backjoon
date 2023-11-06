import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> queue = new LinkedList<>();

        int n = Integer.valueOf(br.readLine());
        int temp;
        while (true){
            temp = Integer.valueOf(br.readLine());
            if (temp == -1)
                break;
            if (temp == 0)
                queue.remove();
            else {
                if (queue.size() < n)
                    queue.add(temp);
            }

        }
        if (queue.isEmpty()){
            System.out.println("empty");
        }
        else {
            int size = queue.size();
            for (int i = 0; i < size; i++){
                bw.write(queue.poll() + " ");

            }
            bw.flush();
            bw.close();
        }
    }
}