import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 입력받은 수를 int 배열에 집어 넣기, 이제 스택을 1부터 n까지 오름차순으로 넣을건데, 만약 지금 나와야 하는 수가 스택에 있는 수보다 크면 push, 같으면 pop 하기 만약 peek 보다 그다음수가 낮다면, No출력 peek 가 없어도 No
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.valueOf(br.readLine());
        int[] arr = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            arr[i] = Integer.valueOf(br.readLine());
        }
        List<String> answer = new ArrayList<>();
        boolean isCanStack = true;
        int curPos = 0;

        int num = 1;
        stack.push(num);

        answer.add("+");

        while(true){

            if(stack.isEmpty()){
                stack.push(++num);
                answer.add("+");
            }

            if(arr[curPos] == stack.peek()){
                stack.pop();
                answer.add("-");
                curPos++;
                if(curPos == n)
                    break;
            }
            else if(arr[curPos] > stack.peek()){
                stack.push(++num);
                answer.add("+");
            }
            else {
                isCanStack = false;
                break;
            }
        }
        if(!isCanStack){
            bw.write("NO");
        }
        else {
            for (String a : answer){
                bw.write(a + '\n');
            }
        }
        bw.flush();
        bw.close();


    }
}