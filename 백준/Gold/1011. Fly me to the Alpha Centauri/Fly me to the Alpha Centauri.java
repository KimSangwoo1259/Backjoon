import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        int t = Integer.valueOf(br.readLine());

        while (t --> 0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.valueOf(st.nextToken());
            int y = Integer.valueOf(st.nextToken());

            int dif = y - x;
            int num = (int) Math.floor(Math.sqrt(dif));
            int answer = num * 2 - 1;
            int temp = dif - num * num;
            if (temp != 0){
                if (temp > num){
                    answer += 2;
                }
                else
                    answer++;
            }
            sb.append(answer + "\n");
        }
        System.out.println(sb);
    }
}