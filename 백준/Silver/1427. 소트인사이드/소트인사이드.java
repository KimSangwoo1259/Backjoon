import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextLong();
        String s = String.valueOf(num);

        int answer = 0;
        List<Character> chars = new ArrayList<>();

        for(char ch : s.toCharArray()){
            chars.add(ch);
        }

        chars.sort(Comparator.naturalOrder()); //오름차순 정렬


        for(int i = 0; i< chars.size(); i++){
            int temp = Character.getNumericValue(chars.get(i));
            double tenpow = Math.pow(10,i);
            answer += temp*tenpow;
        }

        System.out.println(answer);





    }
}