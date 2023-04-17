import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{

    // 1자리수는 1씩, 2자리수는 2씩 이렇게 증가..
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        int weight = 1;
        int num = 10;
        for(int i = 1; i<=n; i++){
            if(i % num == 0){
                weight++;
                num = num * 10;
            }
            answer+=weight;

        }
        System.out.println(answer);

    }
}