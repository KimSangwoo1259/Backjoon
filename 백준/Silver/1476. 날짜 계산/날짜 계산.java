import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int E = scanner.nextInt();
        int S = scanner.nextInt();
        int M = scanner.nextInt();

        scanner.close();
        int year = 0;

        int pe = 0, ps = 0,pm = 0;
        while(true){
            pe = (pe % 15) + 1;
            ps = (ps % 28) + 1;
            pm = (pm % 19) + 1;
            year++;
            if(pe == E && ps == S && pm == M)
                break;
        }
        System.out.println(year);
    }
}