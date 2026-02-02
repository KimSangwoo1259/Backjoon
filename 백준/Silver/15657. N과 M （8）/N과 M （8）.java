import java.io.*;

import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;


public class Main {


    static int n;
    static int m;
    static int[] arr;
    static int[] ans;
    static StringBuilder sb;
    static boolean[] selected;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        selected = new boolean[n];
        ans = new int[m];
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        recursion(0);
        System.out.println(sb);
    }

    private static void recursion(int index) {
        if (index == m){
            sb.append(Arrays.stream(ans)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" "))).append("\n");
        }
        else {
            for (int i = 0; i < n; i++){
                    ans[index] = arr[i];
                    if (index > 0 && ans[index - 1] > arr[i])
                        continue;
                    recursion(index + 1);
                }
            }
        }

}