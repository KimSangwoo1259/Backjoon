import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer line = Integer.valueOf(br.readLine());
        Set<String> employeeSet = new HashSet<>();
        for (int i = 0; i < line; i++){
            String[] check = br.readLine().split(" ");
            String name = check[0];
            String action = check[1];
            if (action.equals("enter")){
                employeeSet.add(name);
            }
            else {
                employeeSet.remove(name);
            }
        }
        Set<String> answerSet = new TreeSet<>(Comparator.reverseOrder());
        answerSet.addAll(employeeSet);

        StringBuilder sb = new StringBuilder();

        for (String str: answerSet){
            sb.append(str).append("\n");
        }

        System.out.println(sb);




    }
}