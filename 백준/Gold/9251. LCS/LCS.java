import java.io.*;

public class Main {



    // a[i] == b[j] -> dp[i][j] = dp[i-1][j-1] +1
    // else ? -> dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j])
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        int len1 = s1.length();
        int len2 = s2.length();
        int ans = 0;

        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <=len1; i++){
            char a = s1.charAt(i - 1);
            for (int j = 1; j <=len2; j++){
                char b = s2.charAt(j - 1);
                if (a == b){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(dp[i][j], ans);
                }
                else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        System.out.println(ans);

    }
}

