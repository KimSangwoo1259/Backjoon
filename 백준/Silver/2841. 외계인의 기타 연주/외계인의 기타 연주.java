import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {

    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int ans = 0;

        Stack[] stackArr = new Stack[n+1];
        for (int i = 1; i <= n; i++){
            stackArr[i] = new Stack<Integer>();
        }

        while(n --> 0){
            st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken());
            int fret = Integer.parseInt(st.nextToken());
            Stack lineStack = stackArr[line];
            if (lineStack.isEmpty()){
                lineStack.push(fret);
                ans++;
            }
            else {
                while(!lineStack.isEmpty() && (int) lineStack.peek() > fret){
                    lineStack.pop();
                    ans++;
                }
                if (lineStack.isEmpty() || (int) lineStack.peek() < fret){
                    lineStack.push(fret);
                    ans++;
                }
            }
        }

        System.out.println(ans);

    }
}