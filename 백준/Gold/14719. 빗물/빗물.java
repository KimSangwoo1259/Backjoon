import java.io.*;
import java.util.*;




public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 0;
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());



        int[] arr = new int[w];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int partSum = 0;
        int wallIndex = 0;
        for (int i = 1; i < w; i++){
                if (arr[i] >= arr[wallIndex]) {
                    ans += (i - wallIndex - 1) * Math.min(arr[i],arr[wallIndex]) - partSum;
                    wallIndex = i;
                    partSum = 0;
                }
                else

                    partSum += arr[i];
        }
        int now = w - 2;
        int curMaxIndex = w-1;
        if (wallIndex != curMaxIndex) {
            while (now > wallIndex) {
                if (arr[curMaxIndex] <= arr[now]) {
                    int tempSum = 0;
                    for (int i = now + 1; i < curMaxIndex; i++) {
                        tempSum += arr[i];
                    }
                    ans += (curMaxIndex - now - 1) * arr[curMaxIndex] - tempSum;
                    curMaxIndex = now;
                }


                now--;
            }
            int tempSum = 0;
            for (int i = wallIndex + 1; i < curMaxIndex; i++) {
                tempSum += arr[i];
            }
            ans += (curMaxIndex - wallIndex - 1) * arr[curMaxIndex] - tempSum;

        }
        System.out.println(ans);
    }
}
// 14719