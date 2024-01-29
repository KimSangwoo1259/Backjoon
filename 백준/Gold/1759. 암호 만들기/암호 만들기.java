import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int l;
    static int c;
    static char[] temp;
    static char[] arr;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.valueOf(st.nextToken());
        c = Integer.valueOf(st.nextToken());
        temp = new char[l];
        arr = new char[c];
        visited = new boolean[c];
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++){
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        recursion(0);
        System.out.println(sb);
    }
    static void recursion(int n){
        if (n == l){
            boolean check = false;
            int count = 0;
            for (int i = 0; i < n; i++){
                if (temp[i] == 'a' ||temp[i] == 'e' ||temp[i] == 'i' ||temp[i] == 'o' ||temp[i] == 'u'){
                    check = true;
                }
                else count++;
            }
            if (!check){
                return;
            }

            if (count < 2) {
                return;
            }

            for (int i = 0; i < n; i++){
                sb.append(temp[i]);
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < c; i++){
            if (!visited[i]){
                if (n > 0){
                    if (temp[n-1] > arr[i])
                        continue;
                }
                temp[n] = arr[i];
                visited[i] = true;
                recursion(n + 1);
                visited[i] = false;
            }

        }

    }
}