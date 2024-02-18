import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String l = st.nextToken();
        String r = st.nextToken();
        int ans = 0;
        if (l.length() != r.length()) {
            System.out.println(ans);
            return;
        }


        for (int i = 0; i < l.length(); i++){
            if (l.charAt(i) == r.charAt(i)){
                if (l.charAt(i) == '8')
                    ans++;
            }
            else
                break;

        }
        System.out.println(ans);

    }
}