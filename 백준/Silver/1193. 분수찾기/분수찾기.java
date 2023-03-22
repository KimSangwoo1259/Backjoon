import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int sum = 0;
        int level = 1;
        int top;
        int bottom;
        while(true){
            sum = sum + level;
            if(sum >= X) {
                break;
            }
            level++;
        }
        if(level % 2 == 0){
            top = level - (sum - X);
            bottom = sum-X+1;
        }
        else{
            top = sum-X+1;
            bottom = level - (sum - X);

        }
        System.out.println(top + "/" +bottom);


    }
}