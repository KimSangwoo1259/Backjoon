import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Collectors;


public class Main {


    static class Number {
        int index;
        int value;

        public Number(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i ++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] answer = new int[n];
        Arrays.fill(answer,-1);

        Stack<Number> stack = new Stack<>();

        for (int i = 0; i < n; i ++){
            int value = arr[i];

            while (!stack.isEmpty() && stack.peek().value < value) {
                Number peek = stack.peek();
                answer[peek.index] = value;
                stack.pop();
            }
            stack.push(new Number(i, value));
        }
        System.out.println(Arrays.stream(answer).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }
}
