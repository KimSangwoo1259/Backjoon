import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        for(int i = 0; i < n; i++){
            int size = scanner.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for(int k = 0; k < size; k++){
                int num = scanner.nextInt();
                arr.add(num);
            }
            arr.sort(Comparator.reverseOrder());
            int maxDif = arr.get(0) - arr.get(1);
            for(int l = 1; l < size-1; l++){
                if(maxDif < (arr.get(l) - arr.get(l+1)))
                    maxDif = (arr.get(l) - arr.get(l+1));
            }
            System.out.println("Class " + (i+1));
            System.out.println("Max " + arr.get(0) + ", Min " + arr.get(size-1) + ", Largest gap " + maxDif);
        }

    }
}