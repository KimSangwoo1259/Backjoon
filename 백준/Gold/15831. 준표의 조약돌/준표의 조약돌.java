import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());  // 조약돌 총 개수
        int b = Integer.valueOf(st.nextToken());  // 검은돌 최대개수
        int w = Integer.valueOf(st.nextToken());  // 흰돌 최소개수

        char[] arr ;

        int[] count = new int[22]; //B-> 66 W -> 87 여기선 0, 19 가 B, W 가된다.
        final int ASCII_VALUE = 66;

        String str = br.readLine();
        arr = str.toCharArray();

        int left = 0;
        int right = 0;
        int ans = 0;
        count[arr[right] - ASCII_VALUE]++;
        boolean isBlack = false;
        boolean isWhite = false;

        if (count[0] <= b)
            isBlack = true;
        if (count[21] >= w)
            isWhite = true;

        int wDif;
        int bDif;
        boolean isRight = false;
        if (!isBlack && !isWhite){
            bDif = count[0] - b;
            wDif = w - count[21];

            if (wDif >= bDif) {
                isRight = true;
                right++;
            }
            else {
                isRight = false;
                left++;
            }
        }
        else if(!isBlack && isWhite){
            left++;
            isRight = false;
        }
        else {
            if (isBlack && isWhite)
                ans = Math.max(right - left + 1, ans);

            right++;
            isRight = true;
        }



        while (right < n){
            isBlack = false;
            isWhite = false;
            if (isRight){
                count[arr[right] - ASCII_VALUE]++;
            }
            else {
                count[arr[left-1] - ASCII_VALUE]--;
            }

            if (count[0] <= b)
                isBlack = true;
            if (count[21] >= w)
                isWhite = true;

            if (!isBlack && !isWhite){
                bDif = count[0] - b;
                wDif = w - count[21];

                if (wDif >= bDif) {
                    right++;
                    isRight = true;
                }
                else {
                    left++;
                    isRight = false;
                }
            }
            else if(!isBlack && isWhite){
                left++;
                isRight = false;
            }
            else {
                if (isBlack && isWhite)
                    ans = Math.max(right - left + 1, ans);

                right++;
                isRight = true;
            }
        }
        System.out.println(ans);
    }
}