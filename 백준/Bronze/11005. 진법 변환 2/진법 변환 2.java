import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    // 각 자릿 값들을 리스트에 넣는다
    // size 가 최대 제곱수가 된다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int number = Integer.parseInt(line[0]);
        int digit = Integer.parseInt(line[1]);

        List<Integer> list = new ArrayList<>();

        int k = 0;
        while (true){
            if (number / (int) Math.pow(digit,k) == 0)
                break;
            k++;
        }
        for (int i = k - 1; i >=0; i--){
            int value = number / (int) Math.pow(digit,i);
            list.add(value);
            number -= (int) Math.pow(digit, i) * value;
        }
        StringBuilder sb = new StringBuilder();

        for (int v : list){
            String temp = (v < 10) ? String.valueOf(v) : String.valueOf((char) (v - 10 + 'A'));
            sb.append(temp);
        }
        System.out.println(sb.toString());
    }
}