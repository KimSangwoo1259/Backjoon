import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int count = 0;
        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++){
            String temp = sc.next();
            set.add(temp);
        }
        for (int i = 0; i < M; i++){
            String temp = sc.next();
            if(set.contains(temp))
                count++;
        }
        System.out.println(count);
    }
}