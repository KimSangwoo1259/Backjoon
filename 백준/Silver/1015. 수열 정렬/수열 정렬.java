import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.valueOf(br.readLine());
        Num[] a = new Num[n];

        Integer[] p = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            a[i] = new Num(Integer.valueOf(st.nextToken()), i);
        }
        Arrays.sort(a);
        for (int i = 0; i < n; i++){
            int index = a[i].index;
            p[index] = i;
        }
        for (int i = 0; i < n; i++){
            sb.append(p[i] + " ");
        }
        System.out.println(sb.toString());


    }
    static class Num implements Comparable<Num> {
        public int value,index;
        Num(int v, int i){
            value = v;
            index = i;
        }

        @Override
        public int compareTo(Num o) {
            return value - o.value;
        }
    }

}

