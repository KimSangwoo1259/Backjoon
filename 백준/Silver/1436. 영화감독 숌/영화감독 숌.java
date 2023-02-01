import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.close();
        int answer = 0;
        int count = 0;
        while(true){
            String str = Integer.toString(answer);
            if(str.contains("666"))
                count++;
            if(count == n)
                break;
            answer++;
        }
        System.out.println(answer);
    }
}