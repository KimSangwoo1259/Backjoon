import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());

        int[] arr = new int[n];
        Stack<Integer> stack = new Stack<>();
        int cur = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++){
            arr[i] = Integer.valueOf(st.nextToken());
        }
        int index = 0;
        while(index <= n-1){
            if(arr[index] == cur){
                cur++;
                index++;
            }
            else {
                if(!stack.isEmpty() && stack.peek() == cur){
                    cur++;
                    stack.pop();
                }
                else {
                    stack.push(arr[index]);
                    index++;
                }
            }
        }
        while (!stack.isEmpty()){
            if(cur != stack.peek()){
                System.out.println("Sad");
                return;
            }
            cur++;
            stack.pop();
        }

        System.out.println("Nice");


    }
}