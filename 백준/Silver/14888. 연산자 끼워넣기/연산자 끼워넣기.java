import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int[] arr;
    static int n;
    static int max = -1000000001;
    static int min = 1000000001;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.valueOf(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arr[i] = Integer.valueOf(st.nextToken());
        }
        int[] operator = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++){
            operator[i] = Integer.valueOf(st.nextToken());
        }


        func(0, arr[0],operator[0], operator[1], operator[2], operator[3]);
        System.out.println(max + "\n" + min);

    }
    static void func(int level, int curVal,int add, int sub, int mul, int div) throws IOException {

        if (level == n-1){
            max = Math.max(max, curVal);
            min = Math.min(min, curVal);
        }
        int temp = level +1;
        if (add >0){
            func(temp, curVal + arr[temp],add-1,sub,mul,div);
        }
        if (sub >0){
            func(temp, curVal - arr[temp],add,sub-1,mul,div);
        }
        if (mul >0){
            func(temp, curVal * arr[temp],add,sub,mul-1,div);
        }
        if (div >0){
            func(temp, curVal / arr[temp],add,sub,mul,div-1);
        }


        return;

    }
}