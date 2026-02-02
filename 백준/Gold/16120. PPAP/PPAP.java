import java.io.*;
import java.util.Stack;


public class Main {

    //PPAP 문자열은 P->PPAP 가능 그러면 A문자열을 주목해서 보면 된다.. 그러면 모든작업을 했을때 P로 돌아간다면 그것은 ppap 문자열..
    // 결국 그러면 PPAP -> P 로 바꾸어 가보자
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] str = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();
        int pCount = 0;
        for (int i = 0; i < str.length; i++){
            char cur = str[i];
            if (cur == 'P'){
                stack.push(cur);
                pCount++;
            }
            else { //A 인 경우
                if (i == str.length - 1){
                    System.out.println("NP");
                    return;
                }


                if (pCount >= 2 && str[i+1] == 'P'){
                    pCount-= 2;
                    stack.pop();
                    stack.pop();
                }
                else {
                    System.out.println("NP");
                    return;
                }

            }
        }

        if (stack.size() ==1 && stack.peek() == 'P'){
            System.out.println("PPAP");
        }
        else {
            System.out.println("NP");
        }


    }
}
