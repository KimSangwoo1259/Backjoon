import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt(); // 입력받을 숫자
        int numArr[] = new int [9]; // 0 ~ 8 까지 나온 숫자들 횟수의 합을 담는 배열

        String strNum = Integer.toString(num);
        int[] arrNum = new int[strNum.length()]; //각 자릿수들이 저장된 배열

        for(int i = 0; i < strNum.length(); i++){ // 입력받은 자연수를 자릿수마다 분리
            arrNum[i] = strNum.charAt(i) - '0';
        }
        for(int i = 0; i < arrNum.length; i++){
            if(arrNum[i] == 9) //6 과 9는 같이 쓸 수 있으므로
                numArr[6]++;
            else
                numArr[arrNum[i]]++;
        }
        numArr[6] = (int) Math.ceil((double)numArr[6]/2); //6과 9는 같은 숫자로 봐야하며 1세트에 2개씩 있으므로 2로 나누고 올림

        System.out.println(Arrays.stream(numArr).max().getAsInt()); // 배열내의 최댓값이 필요한 세트 갯수가된다.

    }


}