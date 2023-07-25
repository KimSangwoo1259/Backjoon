import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        char[] arr1 = br.readLine().toCharArray();
        char[] arr2 = br.readLine().toCharArray();

        int n = arr1.length;
        int k = arr2.length;
        int max = 0;
        int dp[][] = new int[n + 1][k + 1];

        for (int i = 1; i <=n; i ++){
            for (int j = 1; j <=k; j++){
                if(arr1[i-1] == arr2[j-1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        System.out.println(max);

    }
}
