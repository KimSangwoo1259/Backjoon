import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int ans1 = 0;
        int ans2 = 0;

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++){
            list.add(Integer.parseInt(br.readLine()));
        }
        list.sort(Comparator.comparingInt(a -> a));


        // N >= m - i 이면 금액 만큼 남은거 곱해주면됨
        // N < m - i
        for (int i = 0; i < m; i++){
            int count = Math.min(n, m - i);
            int price = list.get(i);
            if (count * price > ans2){
                ans1 = price;
                ans2 = count * price;
            }
        }

        System.out.println(ans1 + " "  + ans2);

    }

}