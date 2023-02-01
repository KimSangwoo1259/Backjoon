import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int size = 8;
        int [] oriArr = new int[size];


        for(int i = 0; i < size; i++)
            oriArr[i] = scanner.nextInt();
        int [] newArr = oriArr.clone();

        Arrays.sort(newArr);
        int sum = 0;
        for(int i = 3; i <8; i++){
            sum += newArr[i];
        }
        System.out.println(sum);

        for(int i = 0; i< 8; i++){
            for(int k = 3; k<8; k++){
                if(newArr[k] == oriArr[i]){
                    System.out.print(i+1 + " ");
                    break;
                }

            }
        }
    }






}