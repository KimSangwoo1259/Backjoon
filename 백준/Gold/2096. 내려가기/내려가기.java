import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());
        int dpMax[] = new int[3]; // 최대 값 저장 dp
        int dpMin[] = new int[3]; // 최소 값 저장 dp

        int beforeMax0;
        int beforeMax2;
        int beforeMin0;
        int beforeMin2;


        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int x0 = Integer.valueOf(st.nextToken());
            int x1 = Integer.valueOf(st.nextToken());
            int x2 = Integer.valueOf(st.nextToken());
            if(i == 0){
                dpMax[0] = dpMin[0] = x0;
                dpMax[1] = dpMin[1] = x1;
                dpMax[2] = dpMin[2] = x2;
            }
            else {
                beforeMax0 = dpMax[0]; beforeMax2 = dpMax[2];
                dpMax[0] = Math.max(beforeMax0, dpMax[1]) + x0;
                dpMax[2] = Math.max(beforeMax2, dpMax[1]) + x2;
                dpMax[1] = Math.max(dpMax[1], Math.max(beforeMax0, beforeMax2)) + x1;


                beforeMin0 = dpMin[0]; beforeMin2 = dpMin[2];
                dpMin[0] = Math.min(beforeMin0, dpMin[1]) + x0;
                dpMin[2] = Math.min(beforeMin2, dpMin[1]) + x2;
                dpMin[1] = Math.min(dpMin[1], Math.min(beforeMin0, beforeMin2)) + x1;


            }
        }


        int max = Arrays.stream(dpMax).max().getAsInt();
        int min = Arrays.stream(dpMin).min().getAsInt();
        System.out.println(max + " " + min);

    }
}