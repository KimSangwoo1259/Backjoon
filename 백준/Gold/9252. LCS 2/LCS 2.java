import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        StringBuilder sb = new StringBuilder();
        char[] a = new char[s1.length() + 1];
        char[] b = new char[s2.length() + 1];

        for (int i = 1; i <= s1.length(); i++){
            a[i] = s1.charAt(i - 1);
        }
        for (int i = 1; i <= s2.length(); i++){
            b[i] = s2.charAt(i - 1);
        }

        int dp[][] = new int[s1.length()+1][s2.length()+1];

        for (int i = 1; i <= s1.length(); i++){
            for (int j = 1; j <= s2.length(); j++){
                if (a[i] == b[j]) dp[i][j] = dp[i - 1][j - 1] + 1;

                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        System.out.println(dp[s1.length()][s2.length()]);
        Stack<Character> st = new Stack<>();
        int r = s1.length();
        int c = s2.length();
        while (r >0 && c > 0){
            if (a[r] == b[c]){
                st.push(a[r]);
                r--;
                c--;
            }
            else if (dp[r][c] == dp[r-1][c]) r--;
            else if (dp[r][c] == dp[r][c-1]) c--;
        }
        while (!st.empty()){
            sb.append(st.pop());
        }
        System.out.println(sb.toString());

    }
}

