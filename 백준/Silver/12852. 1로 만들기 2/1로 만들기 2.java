import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0;

        Queue<Num> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        list.add(n);
        q.add(new Num(n, list));

        List<Integer> ans = new ArrayList<>();

        while(!q.isEmpty()){
          Num now = q.poll();
          if (now.value == 1){
              ans = new ArrayList<>(now.list);
              break;
          }
          if (now.value % 3 == 0 && dp[now.value / 3] == Integer.MAX_VALUE){
              int number = now.value / 3;
              List<Integer> temp = new ArrayList<>(now.list);
              temp.add(number);
              q.add(new Num(number, temp));
              dp[number] = Math.min(dp[number], dp[now.value] + 1);
          }
            if (now.value % 2 == 0 && dp[now.value / 2] == Integer.MAX_VALUE){
                int number = now.value / 2;
                List<Integer> temp = new ArrayList<>(now.list);
                temp.add(number);
                q.add(new Num(number, temp));
                dp[number] = Math.min(dp[number], dp[now.value] + 1);
            }
            if (dp[now.value-1] == Integer.MAX_VALUE){
                int number = now.value - 1;
                List<Integer> temp = new ArrayList<>(now.list);
                temp.add(number);
                q.add(new Num(number, temp));
                dp[number] = Math.min(dp[number], dp[now.value] + 1);
            }
        }
        bw.write(dp[1] + "\n");
        for (int num : ans){
            bw.write(num + " ");

        }
        bw.write("\n");
        bw.flush();
        bw.close();

    }
    static class Num{
        int value;
        List<Integer> list = new ArrayList<>();

        public Num(int value, List<Integer> list) {
            this.value = value;
            this.list = list;
        }
    }
}
