import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int u[] = new int [9];
        int s[] = new int [9];

        boolean isWon = false;
        int uScore = 0;
        int sScore = 0;

        for(int i = 0; i <9; i++){
            int n = scanner.nextInt();
            u[i] = n;
        }
        for(int i = 0; i <9; i++){
            int n = scanner.nextInt();
            s[i] = n;
        }
        for(int i = 0; i < 9; i++){
            uScore += u[i];
            if(uScore > sScore)
                isWon = true;
            sScore += s[i];

        }
        if(isWon)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}