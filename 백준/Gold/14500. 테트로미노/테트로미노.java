import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        int square[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                square[i][j] = Integer.valueOf(st.nextToken());
            }
        }
        System.out.println(calSum(square, n, m));

    }

    static int calSum(int arr[][], int n, int m) {
        int sum = 0;

        for (int i = 0; i < n; i++) { // ---- 모양
            for (int j = 0; j < m - 3; j++) {
                sum = Math.max(sum, arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i][j + 3]);
            }
        }
        for (int i = 0; i < n - 3; i++) // ---- 90도 돌린모양
            for (int j = 0; j < m; j++) {
                sum = Math.max(sum, arr[i][j] + arr[i + 1][j] + arr[i + 2][j] + arr[i + 3][j]);
            }
        for (int i = 0; i < n - 1; i++) { // 정사각형 모양
            for (int j = 0; j < m - 1; j++) {
                sum = Math.max(sum, arr[i][j] + arr[i][j + 1] + arr[i + 1][j] + arr[i + 1][j + 1]);
            }
        }
        for (int i = 0; i < n - 2; i++) { // 위로긴 ㄴ자
            for (int j = 0; j < m - 1; j++) {
                sum = Math.max(sum, arr[i][j] + arr[i + 1][j] + arr[i + 2][j] + arr[i + 2][j + 1]);
            }
        }
        for (int i = 0; i < n - 2; i++) { // 위로긴 ㄴ자 옆으로 뒤집기
            for (int j = 1; j < m; j++) {
                sum = Math.max(sum, arr[i][j] + arr[i + 1][j] + arr[i + 2][j] + arr[i + 2][j - 1]);
            }
        }
        for (int i = 0; i < n - 2; i++) { // 위로긴 ㄱ자
            for (int j = 0; j < m - 1; j++) {
                sum = Math.max(sum, arr[i][j] + arr[i][j + 1] + arr[i + 1][j + 1] + arr[i + 2][j + 1]);
            }
        }
        for (int i = 0; i < n - 2; i++) { // 위로긴 ㄱ자 옆으로 뒤집기
            for (int j = 1; j < m; j++) {
                sum = Math.max(sum, arr[i][j] + arr[i][j - 1] + arr[i + 1][j - 1] + arr[i + 2][j - 1]);
            }
        }
        for (int i = 0; i < n - 1; i++) { // 옆로긴 ㄴ
            for (int j = 0; j < m - 2; j++) {
                sum = Math.max(sum, arr[i][j] + arr[i + 1][j] + arr[i + 1][j + 1] + arr[i + 1][j + 2]);
            }
        }
        for (int i = 0; i < n - 1; i++) { // 옆로긴 ㄴ 옆으로 뒤집기
            for (int j = 2; j < m; j++) {
                sum = Math.max(sum, arr[i][j] + arr[i + 1][j] + arr[i + 1][j - 1] + arr[i + 1][j - 2]);
            }
        }
        for (int i = 0; i < n - 1; i++) { // 옆로긴 ㄱ
            for (int j = 0; j < m - 2; j++) {
                sum = Math.max(sum, arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 2]);
            }
        }
        for (int i = 0; i < n - 1; i++) { // 옆로긴 ㄱ 옆으로 뒤집기
            for (int j = 2; j < m; j++) {
                sum = Math.max(sum, arr[i][j] + arr[i][j - 1] + arr[i][j - 2] + arr[i + 1][j - 2]);
            }
        }
        for (int i = 0; i < n - 1; i++) { // ㄹ 자
            for (int j = 0; j < m - 2; j++) {
                sum = Math.max(sum, arr[i][j] + arr[i][j + 1] + arr[i + 1][j + 1] + arr[i + 1][j + 2]);
            }
        }
        for (int i = 0; i < n - 1; i++) { // ㄹ 자 옆으로 뒤집기
            for (int j = 2; j < m ; j++) {
                sum = Math.max(sum, arr[i][j] + arr[i][j - 1] + arr[i + 1][j - 1] + arr[i + 1][j - 2]);
            }
        }
        for (int i = 0; i < n - 2; i++) { // ㄹ 뒤집기 왼쪽위
            for (int j = 0; j < m - 1; j++) {
                sum = Math.max(sum, arr[i][j] + arr[i+1][j] + arr[i + 1][j + 1] + arr[i + 2][j + 1]);
            }
        }
        for (int i = 0; i < n - 2; i++) { // ㄹ 뒤집기 오른쪽위
            for (int j = 1; j < m; j++) {
                sum = Math.max(sum, arr[i][j] + arr[i+1][j] + arr[i + 1][j - 1] + arr[i + 2][j - 1]);
            }
        }
        for (int i = 0; i < n - 1; i++) { // ㅗ 자
            for (int j = 1; j < m - 1; j++) {
                sum = Math.max(sum, arr[i][j] + arr[i+1][j] + arr[i + 1][j + 1] + arr[i + 1][j - 1]);
            }
        }
        for (int i = 0; i < n - 1; i++) { // ㅜ 자
            for (int j = 1; j < m - 1; j++) {
                sum = Math.max(sum, arr[i][j] + arr[i][j-1] + arr[i][j + 1] + arr[i + 1][j]);
            }
        }
        for (int i = 1; i < n - 1; i++) { // ㅓ 자
            for (int j = 1; j < m; j++) {
                sum = Math.max(sum, arr[i][j] + arr[i+1][j] + arr[i - 1][j] + arr[i][j - 1]);
            }
        }
        for (int i = 1; i < n - 1; i++) { // ㅏ 자
            for (int j = 0; j < m-1; j++) {
                sum = Math.max(sum, arr[i][j] + arr[i+1][j] + arr[i - 1][j] + arr[i][j + 1]);
            }
        }
        return sum;


    }
}